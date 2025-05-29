package Exceptions;

public class PrimitiveSnapshot {
    static int p() {
        int v = 10;
        try {
            return v;             
        } finally {
            v = 20; 
        }
    }
    public static void main(String[] args) {
        System.out.println(p()); 
    }
}
