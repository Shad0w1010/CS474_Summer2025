public class StaticInitLocal {
    static int counter = 0;

    static {
        class Bump extends StaticInitLocal {
            Bump() { counter++; }
        }
        new Bump();
        System.out.println("Counter after static init = " + counter);
    }

    public static void main(String[] args) {
        System.out.println("Counter in main = " + counter);
    }
}
