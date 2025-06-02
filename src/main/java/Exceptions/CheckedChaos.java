package Exceptions;

// CheckedChaos.java
// Demonstrates checked-exception narrowing, nested overrides, and a static
// initializer that may explode at load time

import java.io.IOException;

public class CheckedChaos {
    interface Toggle {
        default int press() throws java.io.IOException {
            if (System.nanoTime() % 2 == 0)           // purely to vary outcome
                throw new java.io.IOException("Even nanoseconds are unlucky");
            return 0;
        }
    }

    static class Fuse implements Toggle {
        /* static state manipulated from several places */
        static boolean gaugeInitialized;
        static int     gauge = initGauge();

        private static int initGauge() {
            if (Fuse.gaugeInitialized)                // qualified name avoids
                return 0;                             // illegal forward ref
            Fuse.gaugeInitialized = true;
            if (Math.random() > 0.5)                  // sometimes misbehave
                throw new RuntimeException("Boom during class init"); // unchecked
            return 1;
        }

        /** narrows declaration: no checked exceptions */
        public int press() {
            try {
                Toggle.super.press();                 // may throw checked
            } catch (java.io.IOException io) {
                return gauge++;                       // recover and mutate
            }
            return gauge;
        }

        /* deeper override that may throw an unchecked exception */
        static class InnerFuse extends Fuse {
            public int press() {
                if (gauge == 1)
                    throw new IllegalStateException("Gauge is still 1");
                return super.press();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Toggle t = new Fuse.InnerFuse();
            System.out.println(t.press());
        }
        catch (IOException e) {
            System.out.println("Caught checked: " + e.getMessage());
        }
        catch (RuntimeException re) {
            System.out.println("Caught unchecked: " + re.getMessage());
        }
    }
}
