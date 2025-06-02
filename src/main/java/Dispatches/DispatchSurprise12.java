package Dispatches;

public class DispatchSurprise12 {
    interface Exploder {
        default int blow() { throw new IllegalStateException("boom"); }
        static int safe() { return 474; }
    }
    static class Fuse implements Exploder {
        public int blow() {
            try {
                Exploder.super.blow();   
                return 0;
            } catch (IllegalStateException e) {
                return Exploder.safe();   
            } finally {
                System.out.println("finally");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new Fuse().blow());     
    }
}
