public class DispatchWithHiding {
    static class Base {
        int value = 1;
        void display() { System.out.println("Base.value = " + value); }
    }

    static class Derived extends Base {
        int value = 2;  // hides Base.value
        @Override
        void display() { System.out.println("Derived.value = " + value); }
    }

    public static void main(String[] args) {
        Base ref = new Derived();                 // up-cast
        ref.display();                            // prints 2 (virtual dispatch, JLS §15.12.4.5)
        System.out.println(ref.value);            // prints 1 (field resolution is static, JLS §13.1)
        System.out.println(((Derived) ref).value); // down-cast, prints 2
    }
}
