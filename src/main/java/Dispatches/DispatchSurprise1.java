package Dispatches;

public class DispatchSurprise1 {
    interface Toggle {
        int COUNT = 1;
        default int press() {                       // default implementation
            return COUNT + 1;
        }
        static int echo() {                         // interface static
            return COUNT;
        }
    }
    static class Lever implements Toggle {
        static int COUNT = 10;                      // hides Toggle.COUNT
        public int press() {                        // overrides default
            return COUNT--;                         // post-decrement
        }
        static class Memory extends Lever implements Toggle {
            public int press() {                    // mixes dispatch paths
                return Toggle.echo();               // calls interface static
            }
        }
    }
    public static void main(String[] args) {
        Toggle first  = new Lever();
        Toggle second = new Lever.Memory();
        System.out.println(first.press());          // 10
        System.out.println(second.press());         // 1
        System.out.println(Toggle.echo());          // 1
    }
}
