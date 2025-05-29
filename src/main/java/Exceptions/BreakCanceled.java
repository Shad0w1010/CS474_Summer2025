package Exceptions;

public class BreakCanceled {
    static int k() {
        outer:
        while (true) {
            try {
                break outer; 
            } finally {
                return 7;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(k());
    }
}
