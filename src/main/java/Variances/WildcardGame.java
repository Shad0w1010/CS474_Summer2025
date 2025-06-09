package Variances;

import java.util.ArrayList;
import java.util.List;

class S{}
class C1 extends S{}
class C2 extends C1{}
class C3 extends C2{}
class C5 extends C3{}
class C4 extends C2{}

public class WildcardGame {
    public static void storeValues(List<? super Integer>lst){
        lst.add(3);
    }

    public static Integer obtainValues(List<? extends Integer>lst){
        return lst.get(0);
    }
    public void X(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        storeValues(ints);
//        List<? super Number> newList = ints;
//        newList.add(3.14F);
        System.out.println(ints);
    }

    public static void main(String[] args) {
//        RHS starts
        ArrayList<C3> arc2 = new ArrayList<C3>();
//        arc2.add(new C2());
        arc2.add(new C3());
//        RHS ends
        List<? extends C2> lhsObj1 = arc2;
        C2 c2 = lhsObj1.get(1);
        List<? super C3> lhsObj2 = arc2;
        lhsObj2.add(new C5());
        Object oo = lhsObj2.get(0);

    }
}