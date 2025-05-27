public class GenericCast {
    static class Animal { void speak() { System.out.println("Animal"); } }
    static class Dog extends Animal {
        @Override void speak() { System.out.println("Dog"); }
        void bark() { System.out.println("Woof"); }
    }

    public static void main(String[] args) {
        Object o = new Dog();          // up-cast to Object
        Animal a = (Animal) o;         // down-cast to Animal
        a.speak();                     // virtual dispatch to Dog.speak
        ((Dog) a).bark();              // down-cast to Dog
    }
}
