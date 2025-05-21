package demo;

/**
 * Demonstrates many levels of scope, shadowing, and name
 * hiding in one compilable file.
 */
public class ScopeLab {

    /* Top-level static and instance fields share the same simple name */
    static int value = 1;          // (A)  static field
    static {
        int value = 2;
    }
    /** Static nested class introduces its own shadow */
    static class Level1 {

        /* Shadowing the top-level static ‘value’ */
        static String value = "static-L1";   // (C)

        /** Non-static nested class inside the static one */
        class Level2 {

            /* Instance field shadows (C) inside Level2’s instance methods */
            double value = 3.14;             // (D)

            /** Method with its own local shadowing */
            void show() {

                System.out.println("Level2.this.value           = " + this.value);
                System.out.println("Level1.value (static)        = " + Level1.value);
                System.out.println("ScopeLab.value (static)      = " + ScopeLab.value);

                /* Local variable shadows every earlier binding */
                String value = "local-L2";   // (E)
                System.out.println("local value in show()        = " + value);

                /* Local class inside a method */
                class Local {

                    // Field named ‘value’ hides (E) inside this class
                    long value = 999L;       // (F)

                    void dump() {

                        System.out.println("Local.this.value            = " + this.value);
                        /* Need qualification to reach the different ‘value’ names */
                        System.out.println("outer method’s value (E)    = " + value /* (E) */);
                        System.out.println("Level2.field value (D)      = " + Level2.this.value);
                        System.out.println("Level1.value (static)       = " + Level1.value);
                        System.out.println("ScopeLab.value (static)     = " + ScopeLab.value);
                    }
                }

                new Local().dump();
            }
        }
    }

    /** Instance method adds one more layer of shadowing */
    void experiment() {

        /* Local variable shadows both (A) and (B) */
        int value = 42;             // (G)
        System.out.println("experiment() local value      = " + value);

        /* Anonymous inner class with its own field called ‘value’ */
        Runnable r = new Runnable() {
            int value = 77;         // (H)

            @Override
            public void run() {
                System.out.println("anonymous-field value (H)    = " + this.value);
                System.out.println("method local value (G)       = " + value /* (G) */);
            }
        };
        r.run();

        /* Create the nested hierarchy and observe look-ups */
        Level1 l1 = new Level1();
        Level1.Level2 l2 = l1.new Level2();
        l2.show();
    }

    public static void main(String[] args) {

        ScopeLab outer = new ScopeLab();
        outer.experiment();
    }
}
