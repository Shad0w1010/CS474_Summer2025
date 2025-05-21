public class StaticBrainSurgery {
    class HasStaticInstanceVar {
         static int field = 10;
    }
    
    public static void main(String[] args) {
        StaticBrainSurgery parent = new StaticBrainSurgery();
        StaticBrainSurgery.HasStaticInstanceVar child1 = parent.new HasStaticInstanceVar();
        StaticBrainSurgery.HasStaticInstanceVar child2 = parent.new HasStaticInstanceVar();
        
        System.out.println(child1.field);
        child1.field = 20;
        System.out.println(child2.field);
//        System.out.println(((HasStaticInstanceVar)(null)).field);
    }
}
