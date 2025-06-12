package Variances;

class Base<T> {
    T getValue() { return null; }
}

class Derived extends Base<String> {
    @Override
    String getValue() { return "Covariant Return"; }
}

class TestCovariantReturn {
    public static void main(String[] args) {
        Base<String> base = new Derived();
        System.out.println(base.getValue());
    }
}
