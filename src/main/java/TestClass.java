public class TestClass {
    int y = 1;

    public TestClass() {
        y = 2;
        f();
    }

    void f() {
        System.out.println("Value1 = " + String.valueOf(y));
    }

    public static class B extends TestClass {
        int y = 3;

        public B() {
            f();
        }

        void f() {
            System.out.println("Value2 = " + String.valueOf(y));
        }
    }

    public static void main(String[] args) {
        new TestClass.B();
    }
}
