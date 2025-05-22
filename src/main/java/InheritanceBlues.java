public class InheritanceBlues {
    abstract class Parent {
        void hasChildren() {
            System.out.println("Parent with children");
        }
        abstract boolean caresAboutChildren();
    }
    
    class Father extends Parent {
        @Override
        boolean caresAboutChildren() {
            return true;
        }

/*        @Override
        void hasChildren() {
            super.hasChildren();
        }*/
    }
    
    public static void main(String[] args) {
        new InheritanceBlues().new Father().hasChildren();
    }
}
