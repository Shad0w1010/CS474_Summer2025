package Interfaces;

interface PaymentGateway {
    boolean pay(int cents);
    default void log(String msg) { System.out.println("[GW] "+msg); }
    static boolean validAmount(int cents){ return cents>0; }
}

class PayPal implements PaymentGateway {
    public boolean pay(int cents){
        log("PayPal processing " + cents + ", stat: " + Stats.tx);
        return PaymentGateway.validAmount(cents);
    }
    static class Stats { static int tx; }          // static nested class
}

public class DemoPay {
    public static void main(String[] a){
        PaymentGateway gw = new PayPal();
        gw.pay(2500);                              // virtual call
        PayPal.Stats.tx++;
        gw.pay(7500);                              // virtual call
        PayPal.Stats.tx++;

    }
}
