package Dispatches;

// DispatchIllusion.java
// Juggles checked and unchecked throws through virtual dispatch chains
// and shows default-method recovery that wraps a checked exception

public class DispatchIllusion {
    interface Courier {
        String deliver() throws java.text.ParseException;

        /** default wrapper converts checked to unchecked */
        default String track() {
            try {
                return deliver();
            } catch (java.text.ParseException pe) {
                throw new RuntimeException("Lost in transit", pe);
            }
        }
    }

    static class Pigeon implements Courier {
        int id = 99;

        /** declares the same checked exception */
        public String deliver() throws java.text.ParseException {
            if ((id & 1) == 1)                        // odd is trouble
                throw new java.text.ParseException("Odd id " + id, 0);
            return "Delivered " + id;
        }

        /* turbo bird that throws only unchecked exceptions */
        static class TurboPigeon extends Pigeon {
            public String deliver() {                 // narrows to none-checked
                if (id == 99)
                    throw new IllegalArgumentException("Stubborn bird");
                return "Zoom " + id;
            }
        }
    }

    /** another path via interface extension and its own default */
    interface Express extends Courier {
        default String deliver() throws java.text.ParseException {
            return "Express OK";
        }
        static String inquire() { return "Static inquiry complete"; }
    }

    public static void main(String[] args) {
        Courier fast = new Pigeon.TurboPigeon();
        System.out.println(fast.track());             // may be normal or throw

        Express exp = new Express() {};               // anonymous implementation
        System.out.println(exp.track());              // always fine

        try {
            Courier slow = new Pigeon();              // triggers checked path
            System.out.println(slow.track());
        } catch (RuntimeException re) {
            System.out.println("Intercepted cause: " + re.getCause());
        }

        System.out.println(Express.inquire());
    }
}
