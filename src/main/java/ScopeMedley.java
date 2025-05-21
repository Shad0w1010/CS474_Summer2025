public class ScopeMedley {
    {
        System.out.println("scope 1");
    }
    int field = m();

    {
        System.out.println("scope 2");
    }

    public ScopeMedley() {
        System.out.println("scope 5");
        System.out.println(field);
    }
    
    int m(){
        System.out.println(field);
        field = 101;
        System.out.println(field);
        System.out.println("scope m");
        return 10;
    }        
    
    static {
        System.out.println("scope 3");
    }

    static {
        System.out.println("scope 4");
    }
    
    public static void main(String[] args) {
//        System.out.println("ScopeMedley");
        new ScopeMedley();
        //3, 1, m, 2, 3 - moh
        //3,1,m, 2 -rob, zak
        //
    }
}
