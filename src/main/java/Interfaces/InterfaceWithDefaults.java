package Interfaces;

public class InterfaceWithDefaults {
    interface Panel4ElectronicDevice {
        default void on_off(boolean on) {
            if (on == true) {
                System.out.println("It's on!!");
                init();
            } else {
                System.out.println("It's off!!");
                shutdown();
            }
        }
        void init();
        void shutdown();
    }

    static class SamsungTV implements Panel4ElectronicDevice {
        @Override
        public void init() {
            System.out.println("Samsung TV: init");
        }

        @Override
        public void shutdown() {
            System.out.println("Samsung TV: shutdown");
        }
    }
    public static void main(String[] args) {
        new SamsungTV().on_off(true);
        new SamsungTV().on_off(false);
    }
}
