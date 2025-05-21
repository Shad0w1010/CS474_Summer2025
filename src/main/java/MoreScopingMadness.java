public class MoreScopingMadness {
    
    static class A {
        class B {
            static class C {
                static class D {
                    class E {
                        static class F {}
                    }   
                }
            }
        }
    }
    
    public static void main(String[] args) {
        MoreScopingMadness p = new MoreScopingMadness();
        A a = new MoreScopingMadness.A();
        A a1 = new A();
        A.B b = new A().new B();
        A.B.C c = new A.B.C();
        A.B.C.D d = new A.B.C.D();
        A.B.C.D.E e = new A.B.C.D().new E();
        A.B.C.D.E.F f = new A.B.C.D.E.F();
        
        System.out.println( "");
    }
}
