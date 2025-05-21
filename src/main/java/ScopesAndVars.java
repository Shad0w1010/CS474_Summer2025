public class ScopesAndVars {
    int field = 5;
    {
        {
            {
                field = 10;
                {
                    int field = 90;
                    {
//                        int field = 1;
                        {
                           field = 100; 
                        }
                    }
                }
            }
        }
    }

    void m(float p) {
        System.out.println("float: " + p);
    }
    
    void m(double p) {
        System.out.println("double: " + p);
    }
    
    public static void main(String[] args) {
        System.out.println(new ScopesAndVars().field);
        new ScopesAndVars().m(1.0);
    }
}
