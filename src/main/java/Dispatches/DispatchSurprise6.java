package Dispatches;

public class DispatchSurprise6 {
    interface Clock {
        default long tick() { return System.currentTimeMillis(); }
        static class SecondHand implements Clock {
            int offset = 5;
            public long tick() {
                return Helper.adjust(Clock.super.tick(), offset);
            }
        }
        static class Helper {
            static long adjust(long t, int off) { return t + off; }
        }
    }
    public static void main(String[] args) {
        Clock c = new Clock.SecondHand();
        System.out.println(c.tick() >= System.currentTimeMillis() - 5);
    }
}
