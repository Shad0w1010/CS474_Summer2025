public class AccessContainerClassMember {
    int x = 10;
    class Inner {
        int x = 20;
        void f() {
            //write code to change the value of the instance variable x in the class AccessContainerClassMember to 100
        }
    }
    public static void main(String[] args) {
        AccessContainerClassMember p = new AccessContainerClassMember();
        p.new Inner().f();
        System.out.println(p.x); //should print out 100
        System.out.println(p.new Inner().x); //should print out 20
    }
}
