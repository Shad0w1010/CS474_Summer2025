package Exceptions;

public class ContinueAlwaysFinally {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            try {
                if (i < 2) continue;
                System.out.println("body " + i);
            } finally {
                System.out.println("finally " + i);
            }
        }
    }
}
