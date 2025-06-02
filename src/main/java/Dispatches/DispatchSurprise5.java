package Dispatches;

public class DispatchSurprise5 {
    interface A { default String name() { return "A"; } }
    interface B extends A { default String name() { return "B"; } }
    interface C extends A { default String name() { return "C"; } }
    static class D implements B, C {
        public String name() {
            return B.super.name() + C.super.name();  // resolves diamond
        }
    }
    public static void main(String[] args) {
        System.out.println(new D().name());          // BC
    }
}
