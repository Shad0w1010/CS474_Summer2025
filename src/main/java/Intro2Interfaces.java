public class Intro2Interfaces {
    interface Empty {}
    interface Empty1 {}
    interface A { 
//        int i;
        void f(); }
    interface B extends A { void g(); }
    interface Im1 {void m();}
    interface Im2 {void m();}
    
    class Imm implements Im1, Im2{
        @Override
        public void m() {
            System.out.println("Imm::m");
        }
    }
    
    class C implements Empty{
        void f(){
            System.out.println("C::f");
        }
    }
    class D extends C{}
    
    public static void main(String[] args) {
        System.out.println("Intro to Interfaces");
        new Intro2Interfaces().new Imm().m();
        new A() { public void f() { System.out.println("A::f"); } }.f();
        Empty e = new Intro2Interfaces().new C();
        ((C)e).f();
        if(e instanceof Empty){
            System.out.println("e is an instance of Empty");
        }
    }
}
