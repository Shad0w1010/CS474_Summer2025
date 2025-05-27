public class AmbiguousOverload {
    static class Alpha {
        void g(long v) { System.out.println("Alpha.g(long)"); }
    }

    static class Beta extends Alpha {
        void g(int v) { System.out.println("Beta.g(int)"); }   // overload
    }

    static class Gamma extends Beta {
        @Override
        void g(long v) { System.out.println("Gamma.g(long)"); } // override Alpha.g(long)
    }

    public static void main(String[] args) {
        Beta b = new Gamma();
        b.g(5);      // chooses Beta.g(int) then virtual dispatch, prints Beta.g(int)
        b.g(5L);     // overload picks long, dynamic dispatch prints Gamma.g(long)
    }
}
