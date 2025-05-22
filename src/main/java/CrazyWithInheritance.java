public class CrazyWithInheritance {
    class C1{
        void m(){
            System.out.println("c1");
        }
    }
    class C2 extends C1{
        void m(){
            System.out.println("c2");
        }
    }
    class C3 extends C2{
        void m(){
            System.out.println("c3");
        }
    }
    class C4 extends C1{
        void m(){
            System.out.println("c4");
        }
    }
    class C5 extends C4{
        void m(){
            System.out.println("c5");
        }
    }
    class C6 extends C4{
        void m(){
            System.out.println("c6");
        }
    }
    
    
    //C1: --------------
    //C6: ----------------------
    
    public static void main(String[] args) {
        System.out.println( "CrazyWithInheritance");
        CrazyWithInheritance parent = new CrazyWithInheritance();
        C1 o = parent.new C1();
        C4 o1 = parent.new C6();
        C2 o2 = parent.new C3();

        int i = new CLI().getInput();
        System.out.println(i);
        
        C1 arr[] = {o, o1, o2};
        arr[i].m();
        
    }
}
