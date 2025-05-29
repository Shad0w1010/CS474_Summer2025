package Exceptions;

class BlewIt extends Exception {
    BlewIt() { }
    BlewIt(String s) { super(s); }
}

class BlewIt1 extends Exception {
    BlewIt1() { }
    BlewIt1(String s) { super(s); }
}
class Test {
    static void blowUp() throws BlewIt {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
//        blowUp();
        try {
            blowUp();
        } catch (BlewIt b) {
            System.out.println("Caught BlewIt");
        } finally {
            System.out.println("Uncaught Exception");
        }
    }
}
