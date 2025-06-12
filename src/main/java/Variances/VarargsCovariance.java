package Variances;

import java.util.Arrays;
import java.util.List;

class VarargsCovariance {
    static void printLists(List<? super Number>... lists) {
        for (List<? super Number> list : lists)
            System.out.println(list);
    }

    public static void main(String[] args) {
        printLists(Arrays.asList(1, 2, 3), Arrays.asList(4.5, 5.6));
    }
}
