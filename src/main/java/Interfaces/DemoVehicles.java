package Interfaces;

interface Vehicle {
    String name();
    default void start() { System.out.println(name()+" started"); }
    static void diag(Vehicle v){ v.start(); }
}

class Car implements Vehicle {
    int rpm;                                      // instance field
    public String name(){ return "Car"; }
    @Override public void start(){ 
        rpm = 700; 
        Vehicle.super.start(); }

    /* inner interface */
    interface ECU { void flash(); }
}

public class DemoVehicles {
    public static void main(String[] args) {
        Vehicle v = new Car();
        Vehicle.diag(v);                          // static method
        ((Car.ECU)() -> System.out.println("ECU flashed")).flash();
    }
}
