interface Human {
    void luv();
}

interface Machine {
    void kill();
}

class Schwarz implements Human, Machine {
    @Override
    public void luv() {
        System.out.println("luv");
    }

    @Override
    public void kill() {
        System.out.println("kill");
    }
}

class T1000 implements Human, Machine {
    @Override
    public void luv() {
        System.out.println("don't luv");
    }

    @Override
    public void kill() {
        System.out.println("kill more");
    }
}

class OConnor implements Human {
    @Override
    public void luv() {
        System.out.println("don't luv");
    }
}

public class Terminator {
    <T extends Human & Machine> void dealWithTerminator(T t){
        t.kill();
        t.luv();
    }
    
    public static void main(String[] args) {
        Terminator terminator = new Terminator();
        terminator.dealWithTerminator(new Schwarz());
        terminator.dealWithTerminator(new T1000());
//        terminator.dealWithTerminator(new OConnor());
/*        terminator.dealWithTerminator(new Human(){
            @Override
            public void luv() {}
        });*/
    }
}
