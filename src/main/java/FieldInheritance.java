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
        public Child() {
            super.me = this;
        }

        void mm() {
            System.out.println("Child from Hell!!!");
        }
    }
    
    public FieldInheritance() {
        Parent p = new Child();
        Parent p1 = new Parent();
        System.out.println(p.me.field);
        System.out.println(p1.me.field);
        p.me.mm();
        p1.me.mm();
    }
    
    public static void main(String[] args) {
        new FieldInheritance();
    }
}
