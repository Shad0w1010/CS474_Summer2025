public class InitOrder {
    static { System.out.println("Outer static block"); }

    static class Inner {
        static { System.out.println("Inner static block"); }
    }

    public static void main(String[] args) {
        System.out.println("Main begins");
        new Inner();                   // triggers Inner’s <clinit>
    }
}
