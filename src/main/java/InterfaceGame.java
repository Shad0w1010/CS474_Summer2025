public class InterfaceGame {
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
