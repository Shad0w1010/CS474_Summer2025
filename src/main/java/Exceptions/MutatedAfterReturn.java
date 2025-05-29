package Exceptions;

public class MutatedAfterReturn {
    static int[] box() {
        int[] a = {1};
        try {
            return a;             // reference captured
        } finally {
            a[0] = 99;            // changes object after capture
        }
    }
    public static void main(String[] args) {
        System.out.println(box()[0]);  // prints 99
    }
}