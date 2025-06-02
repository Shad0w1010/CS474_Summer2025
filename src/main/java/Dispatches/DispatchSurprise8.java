package Dispatches;

public class DispatchSurprise8 {
    interface Noise {
        static String SOUND = "buzz";
        default String sound() { return SOUND; }
    }
    static class Bee implements Noise {
        static String SOUND = "sting";               // hides Noise.SOUND
        public String sound() {
            return SOUND + "-" + Noise.SOUND;        // combines the two
        }
        class Hive { String echo() { return Bee.this.sound(); } }
    }
    public static void main(String[] args) {
        Bee b = new Bee();
        System.out.println(b.new Hive().echo());     // sting-buzz
    }
}
