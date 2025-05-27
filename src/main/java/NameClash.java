public class NameClash {
    static class X {
        static int tag = 1;

        static class Y {
            static int tag = 2;       // hides X.tag
            void show() {
                System.out.println("Y.tag  = " + tag);
                System.out.println("X.tag  = " + X.tag);
                System.out.println("Top    = " + NameClash.X.tag);
            }
        }
    }

    public static void main(String[] args) {
        new X.Y().show();
    }
}
