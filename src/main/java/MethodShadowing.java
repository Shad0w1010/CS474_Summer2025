public class MethodShadowing {
    static class A {
        void f(int x) { System.out.println("A.f(int) = " + x); }
    }

    static class B extends A {
        void f(double x) { System.out.println("B.f(double) = " + x); } // overload, not override
    }

    public static void main(String[] args) {
        A a = new B();
        a.f(5);                          // chooses A.f(int) after overload resolution
        ((B) a).f(5);                    // chooses B.f(double)
        ((B) a).f(5.0f);                 // still B.f(double) after primitive widening (§5.1.2)
    }
}
