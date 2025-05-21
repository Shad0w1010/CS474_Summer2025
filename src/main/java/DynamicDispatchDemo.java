// DynamicDispatchDemo.java
//  javac --enable-preview --release 21 DynamicDispatchDemo.java
//  java  --enable-preview DynamicDispatchDemo

import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;

/**
 * Show-cases “dynamic dispatch” techniques that do **not** depend on
 * subclass overrides or the JVM’s built-in virtual-method tables.
 *
 * ─── What is dispatched ─────────────────────────────────────────────
 *   Three immutable command objects, each a Java 21 record:
 *       • Add(x,y)        – produce sum
 *       • Upper(s)        – upper-case a string
 *       • Quit()          – terminate the loop
 *
 *   The main loop feeds the same List<Object> to five independent
 *   dispatching strategies:
 *       1. pattern-matching  switch  (instanceof + binding)
 *       2. reflection by naming convention
 *       3. MethodHandle table
 *       4. Class → Consumer map
 *       5. dynamic proxy that routes all calls through InvocationHandler
 *───────────────────────────────────────────────────────────────────── */
public class DynamicDispatchDemo {

    /* ── three data “messages” – NO common super-type, no methods ── */
    public record Add   (int x, int y) { }
    public record Upper (String text)  { }
    public record Quit  (               ) { }

    // #1 –––––––––  pattern-matching  switch  –––––––––––––––––––––––
    static Object switchDispatch(Object msg) {
        return switch (msg) {
            case Add   (int a, int b) -> a + b;
            case Upper (String s)     -> s.toUpperCase();
            case Quit  q              -> q;                  // sentinel
            default                  -> throw new IllegalArgumentException(msg.toString());
        };
    }

    // #2 –––––––––  reflection by naming convention  ––––––––––––––––
    static final class ReflectRouter {
        private final Map<Class<?>, Method> cache = new HashMap<>();
        Object dispatch(Object msg) {
            try {
                Method m = cache.computeIfAbsent(msg.getClass(),
                        k -> {
                            try { return getClass().getDeclaredMethod("on" + k.getSimpleName(), k); }
                            catch (NoSuchMethodException e) { throw new RuntimeException(e); }
                        });
                return m.invoke(this, msg);
            } catch (InvocationTargetException ite) {
                throw new RuntimeException(ite.getCause());
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
        /* handler methods discovered reflectively */
        private int     onAdd  (Add   r) { return r.x() + r.y(); }
        private String  onUpper(Upper r) { return r.text().toUpperCase(); }
        private Quit    onQuit (Quit  r) { return r; }
    }

    // #3 –––––––––  MethodHandle table (fast reflection) ––––––––––––
    static final class MHRouter {
        private final Map<Class<?>, MethodHandle> table = new HashMap<>();
        MHRouter() {
            try {
                MethodHandles.Lookup L = MethodHandles.lookup();
                table.put(Add  .class, L.findStatic(MHRouter.class, "hAdd",
                        MethodType.methodType(int.class, Add.class)));
                table.put(Upper.class, L.findStatic(MHRouter.class, "hUpper",
                        MethodType.methodType(String.class, Upper.class)));
                table.put(Quit .class, L.findStatic(MHRouter.class, "hQuit",
                        MethodType.methodType(Quit.class, Quit.class)));
            } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
        }
        Object dispatch(Object msg) {
            try {
                return table.get(msg.getClass()).invoke(msg);
            } catch (Throwable t) { throw new RuntimeException(t); }
        }
        /* static handlers */
        private static int    hAdd  (Add r)   { return r.x() + r.y(); }
        private static String hUpper(Upper r) { return r.text().toUpperCase(); }
        private static Quit   hQuit (Quit r)  { return r; }
    }

    // #4 –––––––––  Class → Consumer table –––––––––––––––––––––––––––
    static final class FnRouter {
        private final Map<Class<?>, Function<Object,Object>> fns = Map.of(
                Add  .class, m -> ((Add)  m).x() + ((Add)  m).y(),
                Upper.class, m -> ((Upper)m).text().toUpperCase(),
                Quit .class, m -> m
        );
        Object dispatch(Object msg) { return fns.get(msg.getClass()).apply(msg); }
    }

    // #5 –––––––  Dynamic Proxy – all calls go through one handler ––
    interface Processor { Object apply(Object x); }   // single-method iface
    static Processor newProxy() {
        InvocationHandler h = (proxy, method, args) -> switchDispatch(args[0]);
        return (Processor) Proxy.newProxyInstance(
                Processor.class.getClassLoader(),
                new Class<?>[] { Processor.class }, h);
    }

    /* ─────────  Driver to show identical results  ───────────────── */
    public static void main(String[] args) {

        List<Object> script = List.of(
                new Add(2,3),
                new Upper("boltzmann"),
                new Add(9,1),
                new Quit()
        );

        ReflectRouter  reflect = new ReflectRouter();
        MHRouter       mhr     = new MHRouter();
        FnRouter       fnr     = new FnRouter();
        Processor      proxy   = newProxy();

        System.out.println("switch   reflect   MH-table  fn-map   proxy");
        for (Object msg : script) {
            System.out.printf("%8s %9s %11s %8s %8s%n",
                    fmt(switchDispatch(msg)),
                    fmt(reflect.dispatch(msg)),
                    fmt(mhr.dispatch(msg)),
                    fmt(fnr.dispatch(msg)),
                    fmt(proxy.apply(msg)));
        }
    }
    private static String fmt(Object o) {
        return (o instanceof Quit) ? "QUIT" : o.toString();
    }
}
