package Exceptions;

public class RecursiveFinally {
    static int depth = 0;
    static int f() {
        if (depth == 0) {
            return 1;
        }  else {
        return r();}
    }
    static int r() {
        try {
            return depth++;
        } finally {
            f();
        }
    }
    public static void main(String[] args) {
        int retval = r();
        System.out.println(retval);
    }
}
