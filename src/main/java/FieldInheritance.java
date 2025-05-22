public class FieldInheritance {
    class Parent {
        int field = 10;
        Parent me = this;
        void mm() {
            System.out.println("Me,me,me!!!");
        }
    }
    
    class Child extends Parent {
        int field = 20;
    }
    
    public FieldInheritance() {
        Parent p = new Child();
        System.out.println(p.me.field);
        p.me.mm();
    }
    
    public static void main(String[] args) {
        new FieldInheritance();
    }
}
