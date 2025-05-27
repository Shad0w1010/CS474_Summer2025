public class LocalClassDemo {
    int value = 10;
    void test() {
        final int value = 20;          // effectively final

        class Local {
            void print() {
                System.out.println("Outer instance value = " + LocalClassDemo.this.value);
                System.out.println("Method value         = " + value);
            }
        }

        new Local().print();
    }

    public static void main(String[] args) {
        new LocalClassDemo().test();
    }
}
