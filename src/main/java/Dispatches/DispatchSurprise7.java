package Dispatches;

public class DispatchSurprise7 {
    interface Counter {
        static int VALUE = init();             
        static int init() {
            System.out.println("Counter initialising");
            return 0;
        }
        default int next() { return VALUE + 1; }
    }
    static class Meter implements Counter {
        static { System.out.println("Meter static, VALUE=" + Counter.VALUE); }
    }
    public static void main(String[] args) {
        Counter c = new Meter();
        System.out.println(c.next());
    }
}
