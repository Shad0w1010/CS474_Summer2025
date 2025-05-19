public class BindingsNames {
    int field = 5;
    
    public void setField(int p) {
        field = p;
    }
    public static void main(String[] args) {
        int varrr= 10;
        new BindingsNames().setField(varrr);
        System.out.println(new BindingsNames().field);
    }
}
