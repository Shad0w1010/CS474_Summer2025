package Variances;

import java.util.function.Consumer;

class Contravariant {
    static <T> void consume(T t, Consumer<? super T> consumer) {
        consumer.accept(t);
    }

    public static void main(String[] args) {
        Consumer<Object> printer = System.out::println;
        consume("Hello, Contravariant!", printer);
    }
}
