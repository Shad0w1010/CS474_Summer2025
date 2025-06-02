package Dispatches;

public class DispatchSurprise3 {
    int id = 474;
    interface Outer {
        default String greet() {             // uses implementation detail
            return getMarker() + "-outer";
        }
        int getMarker();
        interface Inner extends Outer {
            default String greet() {
                return getMarker() + "-inner";
            }
        }
    }
    static class Announcer extends DispatchSurprise3
            implements Outer.Inner {
        public int getMarker() {
            return id;                    
        }
    }
    public static void main(String[] args) {
        Outer o = new Announcer();
        System.out.println(o.greet());      
    }
}
