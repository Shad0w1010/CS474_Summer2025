public class SelfNested {
    void echo() { System.out.println("SelfNested.echo"); }

    class Child extends SelfNested {
        @Override
        void echo() { System.out.println("Child.echo"); }

        void test() {
            echo();                       // dynamic inside Child, prints Child.echo
            SelfNested.this.echo();       // prints SelfNested.echo
        }
    }

    public static void main(String[] args) {
        SelfNested outer = new SelfNested();
        Child inner = outer.new Child();
        SelfNested up = inner;            // up-cast to outer type
        up.echo();                        // dynamic dispatch prints Child.echo
        inner.test();
    }
}
