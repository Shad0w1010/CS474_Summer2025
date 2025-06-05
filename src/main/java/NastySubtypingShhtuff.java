import java.util.ArrayList;

public class NastySubtypingShhtuff {
    public static void main(String[] args) {
        String [] lst = new String[10];
        lst[0] = "a";
        Object [] obj = lst;
        obj[0] = 2;
        
    }
}
