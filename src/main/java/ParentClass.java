public class ParentClass {
    int y = 1;

    public ParentClass() {
        y = 2;
        f();
    }

    void f() {
        System.out.println("Value1 = " + String.valueOf(y));
    }

    public static class Child extends ParentClass {
        int y = 3;

        public Child() {
            
            f();
        }

        void f() {
            
            System.out.println("Value2 = " + String.valueOf(y));
        }
    }

    public static void main(String[] args) {
        new Child();
    }
}
