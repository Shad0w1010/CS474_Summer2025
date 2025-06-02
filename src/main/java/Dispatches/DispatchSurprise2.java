package Dispatches;

public class DispatchSurprise2 {
    static int C = 0;
    interface Counter {
        int C = 0;
        default int bump() {
            try {
                return C;           // normal return
            } finally {
//                ++C;
                ++DispatchSurprise2.C;                // abrupt but still updates static
            }
        }
    }
    interface Mirror extends Counter {
        default int bump() {
            return DispatchSurprise2.C--;             // works on the hidden field
        }
    }
    static class Widget  implements Counter {}
    static class Gadget  implements Mirror  {}
    public static void main(String[] args) {
        Counter a = new Widget();
        Counter b = new Gadget();
        System.out.println(a.bump());   // 0
        System.out.println(b.bump());   // 1
        System.out.println(a.bump());   // 1
    }
}
