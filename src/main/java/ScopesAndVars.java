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
    public static void main(String[] args) {
        System.out.println(new ScopesAndVars().field);
    }
}
