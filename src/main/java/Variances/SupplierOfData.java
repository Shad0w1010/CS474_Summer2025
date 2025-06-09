package Variances;

public class SupplierOfData {
    private static Integer [] data = null;
    public static Integer [] takeThisData(int size) {
        if( data == null )
            data = new Integer[size];
        data[0]=1;
        return data;
    }
}
