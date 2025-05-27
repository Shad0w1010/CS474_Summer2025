public class StaticVsInstance {
    static class Base {
        static void ping() { System.out.println("Base.ping"); }
        void pong() { System.out.println("Base.pong"); }
    }

    static class Sub extends Base {
        static void ping() { System.out.println("Sub.ping"); } // hides Base.ping
        @Override
        void pong() { System.out.println("Sub.pong"); }
    }

    public static void main(String[] args) {
        Base ref = new Sub();
        Base.ping();  // static lookup to Base
        Sub.ping();   // static lookup to Sub
        ref.pong();   // dynamic dispatch prints Sub.pong
    }
}
