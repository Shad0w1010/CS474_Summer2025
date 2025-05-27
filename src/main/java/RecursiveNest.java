public class RecursiveNest {
    void who() { System.out.println("Outer"); }

    class Inner extends RecursiveNest {
        @Override void who() { System.out.println("Inner"); }

        void run() {
            RecursiveNest ref1 = this;              // refers to Inner
            ref1.who();                             // prints Inner
            RecursiveNest ref2 = RecursiveNest.this; // enclosing instance
            ref2.who();                             // prints Outer
        }
    }

    public static void main(String[] args) {
        RecursiveNest outer = new RecursiveNest();
        Inner inner = outer.new Inner();
        inner.run();
    }
}
