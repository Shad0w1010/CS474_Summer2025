import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class Fruit implements Comparable<Fruit>{
    protected int color;
    public Fruit(int color){this.color = color; }
    public int compareTo(Fruit fruit){return fruit.color - color;}
}
class Apple extends Fruit{
    List<? super Integer> foo3 = new ArrayList<Object>();
    public Apple() {
        super(1);
    }

    public int compareTo(Apple a) {
        return super.compareTo(a);
    }
}
class Orange extends Fruit{
    public Orange(){super(2);}
    public int compareTo(Orange o) {
        return super.compareTo(o); }
}
public class Generics {

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder(){
        return new Comparator<T>(){
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }
    public static void main(String[] args) {
        Apple a = new Apple();
        Orange o = new Orange();
        Comparator<Fruit> c = Generics.naturalOrder();
        Comparator<Apple> c1 = Generics.naturalOrder();
        Comparator<Orange> c2 = Generics.naturalOrder();
        c.compare(a,o);
    }
} 