package Variances;

import java.io.Serializable;

class IntersectionTypes {
    static <T extends Runnable & Serializable> void executeSerializable(T task) {
        task.run();
    }

    public static void main(String[] args) {
        executeSerializable((Runnable & Serializable) () -> System.out.println("Intersection"));
    }
}
