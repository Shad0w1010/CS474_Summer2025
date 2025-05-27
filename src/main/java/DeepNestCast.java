public class DeepNestCast {
    static class A {
        void who() { System.out.println("A"); }
        static class B extends A {
            @Override void who() { System.out.println("B"); }
            static class C extends B {
                @Override void who() { System.out.println("C"); }
            }
        }
    }

    public static void main(String[] args) {
        A.B.C c = new A.B.C(); // most specific
        A up1 = c;             // up-cast to A
        A.B up2 = c;           // up-cast to B
        up1.who();             // prints C
        up2.who();             // prints C
    }
}
