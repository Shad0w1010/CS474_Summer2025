package Exceptions;

interface Type1 {
    void f() throws CloneNotSupportedException;
//    void f() throws Exception;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}

public class ArcaneStuff implements Type3 {
    public void f() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        Type3 t3 = new ArcaneStuff();
        t3.f();
    }
}