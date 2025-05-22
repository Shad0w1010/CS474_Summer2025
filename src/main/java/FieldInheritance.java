public class FieldInheritance {
    class Parent {
        int field = 10;
    }
    
    class Child extends Parent {
        int field = 20;
    }
    
    public FieldInheritance() {
        Parent p = new Child();
        System.out.println(p.field);
    }
    
    public static void main(String[] args) {
        new FieldInheritance();
    }
}
