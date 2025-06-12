package Variances;

import java.util.function.Predicate;

class ContravariantPredicate {
    static boolean testString(String s, Predicate<? super String> predicate) {
        return predicate.test(s);
    }

    public static void main(String[] args) {
        Predicate<Object> nonNull = obj -> obj != null;
        System.out.println(testString("Test", nonNull));
        System.out.println(testString(null, nonNull));
    }
}
