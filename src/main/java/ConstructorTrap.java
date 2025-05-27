public class ConstructorTrap {
    static int n = 1;
    
    ConstructorTrap() {
        System.out.println("n in constructor = " + n);
    }

    static class Sub extends ConstructorTrap {
        int n = 3;
        Sub() { System.out.println("n in sub-constructor = " + n); }
    }

    public static void main(String[] args) {
        new Sub();
    }
}
