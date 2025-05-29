package Exceptions;

public class ExitFinally {
    static int doom() {
        try {
            return 1;
        } finally {
            System.exit(0); 
        }
    }
    public static void main(String[] args) {
        System.out.println(doom());
    }
}
