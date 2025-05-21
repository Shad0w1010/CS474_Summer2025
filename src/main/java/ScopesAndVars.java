public class ScopesAndVars {
    int field = 5;
    {
        class X{
            class Z {
                void m(float p) {
                    field = 10;
                    System.out.println("m in XZ: " + field);
                }
            }
            class Y{
                class Z {
                    void m(float p) {
                        class X1 {
                            class Y1 {
                                class Z1 {
                                    void m(float p) {
                                        field = 10;
                                        System.out.println("m in X1Y1Z1: " + field);
                                    }
                                }
                            }
                        }
                        X1.Y1.Z1 o = new X1().new Y1().new Z1();
                        o.m(1.0f);
                        field = 10;
                        System.out.println("m in XYZ: " + field);
                    }
                }
            }
        }
        X.Y.Z o = new X().new Y().new Z();
//        X.Y.Z o = new X().new Y().new Z();
//        X.Z o = new X().new Z();
        o.m(1.0f);
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
//        new ScopesAndVars().m(1.0);
    }
}
