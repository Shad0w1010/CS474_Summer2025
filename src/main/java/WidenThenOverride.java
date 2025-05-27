public class WidenThenOverride {
    static class Shape {
        void size(int n) { System.out.println("Shape.size(int) = " + n); }
    }

    static class Square extends Shape {
        void size(double n) { System.out.println("Square.size(double) = " + n); } // overload
        @Override
        void size(int n) { System.out.println("Square.size(int) = " + n); }       // override

        Square() {
            size(4);     // chooses int version (override)
            size(4.5f);  // chooses double version (overload + widening to double)
        }
    }

    public static void main(String[] args) {
        new Square();
    }
}
