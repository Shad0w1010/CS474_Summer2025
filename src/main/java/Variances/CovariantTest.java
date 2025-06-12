package Variances;

class CovariantTest {
    static void printObjects(Object[] objects) {
        for (Object obj : objects)
            System.out.println(obj);
    }

    public static void main(String[] args) {
        String[] strings = {"hello", "world"};
        printObjects(strings); // Array covariance allows this
    }
}