public class CtorHiding {
    static class A {
        int x = 1;
        A() { System.out.println("A.x = " + x); }
    }

    static class B extends A {
        int x = 2;           // hides A.x
        B() {
            System.out.println("B.x = " + x);
            System.out.println("super.x = " + super.x);
        }
    }

    public static void main(String[] args) {
        new B();
    }
}
