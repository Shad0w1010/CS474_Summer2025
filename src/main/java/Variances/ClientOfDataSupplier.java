package Variances;

public class ClientOfDataSupplier {
    public static void main(String[] args) {
        Object[] o = SupplierOfData.takeThisData(3);
        o[0] = "cs474";
//        System.out.println(o[0]);
    }
}
