package Dispatches;

public class DispatchSurprise9 {
    interface Outer {
        int FLAG = 1;
        default int value() { return FLAG; }
        class Wrapper {                            
            interface InnerSignal extends Outer {
                default int value() { return FLAG + 2; }
            }
        }
    }
    static class Impl implements Outer.Wrapper.InnerSignal {}
    public static void main(String[] args) {
        Outer o = new Impl();
        System.out.println(o.value());               // 3
    }
}
