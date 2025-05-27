public class ShadowSpectrum {
    static int v = 0;          // outer-most static field

    static {
        int v = 1;                 // outer instance field
    }
    class Inner {
        int v = 2;             // inner instance field

        void show() {
            int v = 3;         // local variable
            ShadowSpectrum.this.v = 4;       
            System.out.println("Local v           = " + v);
            System.out.println("Inner v           = " + this.v);
            System.out.println("Outer instance v  = " + ShadowSpectrum.this.v);
            System.out.println("Outer static v    = " + ShadowSpectrum.v);
        }
    }

    public static void main(String[] args) {
        ShadowSpectrum outer = new ShadowSpectrum();
        ShadowSpectrum.Inner inner = outer.new Inner();
        inner.show();
    }
}
