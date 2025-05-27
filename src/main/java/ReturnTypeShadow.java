public class ReturnTypeShadow {
    static class X {
        Number value() { return 1; }
    }

    static class Y extends X {
        @Override
        Integer value() { return 2; }  // return-type covariance (§8.4.5)
        int value(int n) { return n * 2; } // overload unrelated to above
    }

    public static void main(String[] args) {
        X ref = new Y();
        System.out.println(ref.value());      // prints 2 via covariant override
        System.out.println(((Y) ref).value(7)); // overload chosen by argument list
    }
}
