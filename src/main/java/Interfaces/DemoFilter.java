package Interfaces;

interface Filter {
    String apply(String in);
    default Filter and(Filter other){        // virtual + default
        return s -> other.apply(apply(s));
    }
    static Filter trim(){ return String::trim; }
    static Filter upper(){ return String::toUpperCase; }
}
public class DemoFilter{
    public static void main(String[] args){
        Filter f = Filter.trim().and(Filter.upper());
        System.out.println(f.apply("  hello  "));
    }
}
