package Dispatches;

public class DispatchSurprise11 {
    interface CloseableThing extends AutoCloseable {
        default void close() { System.out.println("interface close"); }
        default String info() { return "thing"; }
    }
    static class Resource implements CloseableThing {
        String info = "resource";
        public String info() { return info; }
    }
    public static void main(String[] args) {
        try (CloseableThing r = new Resource()) {
            System.out.println(r.info()); 
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("caught");
        }
    }
}
