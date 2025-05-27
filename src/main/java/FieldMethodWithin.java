public class FieldMethodWithin {
    int f = 5;
    void f() { System.out.println("Method f() sees f = " + f); }

    static class Sub extends FieldMethodWithin {
        int f = 10;                    // hides field
        @Override
        void f() { System.out.println("Sub.f() sees f = " + f); }
    }

    public static void main(String[] args) {
        FieldMethodWithin base = new Sub();
        base.f();                      // prints 10 after virtual dispatch
        System.out.println(base.f);    // prints 5 (field hiding is static)
    }
}
