package Interfaces;

interface Policy {
    boolean allowed(String op);
    default void check(String op){
        if(!allowed(op)) throw new SecurityException(op);
    }
    static Policy admin(){ return op -> true; }

    /* inner static interface */
    interface Holder { Policy POLICY = admin(); }
}

class SecureAction{
    void doOp(String op){
        Policy.Holder.POLICY.check(op);         // static + default combo
        System.out.println("Executed "+op);
    }
}

public class DemoSec{
    public static void main(String[]a){ new SecureAction().doOp("reboot"); }
}
