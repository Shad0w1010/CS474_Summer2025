public class BasicStaticScopeWithRef {
    int x = 0;
    
    int f(){
        return x;
    }
    int g(){
        int x = 1;
        return f();
    }
    public static void main(String[] args) {
        System.out.println(new BasicStaticScopeWithRef().g());
    }
}
