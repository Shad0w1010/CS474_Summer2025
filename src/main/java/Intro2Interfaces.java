public class Intro2Interfaces {
    interface Empty {}
    interface Empty1 {}
    interface A { 
//        int i;
        void f(); }
    interface B extends A { void g(); }
    
    class C implements Empty{
        void f(){
            System.out.println("C::f");
        }
    }
    class D extends C{}
    
    public static void main(String[] args) {
        System.out.println("Intro to Interfaces");
        new A() { public void f() { System.out.println("A::f"); } }.f();
        Empty e = new Intro2Interfaces().new C();
        ((C)e).f();
        if(e instanceof Empty){
            System.out.println("e is an instance of Empty");
        }
    }
}
