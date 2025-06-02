package Interfaces;

public class InterfaceGame {
    interface SI{
        void f();
    }
    interface SII extends SI{
        void g();
    }
    
    class C_SII implements SII{
        @Override
        public void f() {
            
        }
        @Override
        public void g() {
            System.out.println("I1.g");
        }
    }
    interface Campus { 
        interface Bldgs{
            interface Floor{
                class RestLounge{
                    void sleep(){
                        System.out.println("I1.I2.C.behavior");
                    }
                }
                void f(RestLounge beers);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Interface Game");
    }
}
