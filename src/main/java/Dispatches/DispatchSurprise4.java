package Dispatches;

public class DispatchSurprise4 {
    interface Alpha {
        int mark = Echo.register("Alpha");   
        default int ping() { return mark; }
        static int touch() { return mark; }
    }
    interface Beta extends Alpha {
        int mark = Echo.register("Beta");       
    }
    static class Echo {
        static int register(String tag) {
            System.out.println("Init " + tag);
            return tag.length();
        }
    }
    static class Tester implements Beta {}
    public static void main(String[] args) {
        Alpha a = new Tester();         
        System.out.println(a.ping());    
        System.out.println(Alpha.touch());
    }
}
