package Dispatches;

public class DispatchSurprise10 {
    interface Game {
        default int points() { return 0; }
        interface Rules { static int bonus(int p) { return p + 10; } }
        static class Player implements Game {
            int personal = 3;
            public int points() { return Rules.bonus(personal); }
            interface Score extends Game {
                default int points() { return 100; }
            }
        }
    }
    public static void main(String[] args) {
        Game normal = new Game.Player();
        System.out.println(normal.points());         // 13
        Game.Player.Score high = new Game.Player.Score() {};
        System.out.println(high.points());           // 100
    }
}
