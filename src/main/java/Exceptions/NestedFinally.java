package Exceptions;

public class NestedFinally {
    static String m() {
        try {
            try {
                return "inner";
            } finally {
                return "middle";
            }
        } finally {
            return "outer";
        }
    }
    public static void main(String[] args) {
        System.out.println(m());  
    }
}
