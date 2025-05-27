public class TieredStatics {
    static class Top {
        static int tag = 1;
        void show() { System.out.println("Top.tag = " + tag); }
    }

    static class Mid extends Top {
        static int tag = 2;           // hides Top.tag (static)
        @Override
        void show() { System.out.println("Mid.tag = " + tag); }
    }

    static class Bot extends Mid {
        static int tag = 3;           // hides Mid.tag (static)
        @Override
        void show() { System.out.println("Bot.tag = " + tag); }
    }

    public static void main(String[] args) {
        Top ref = new Bot();
        ref.show();                         // dynamic dispatch prints 3
        System.out.println(ref.tag);        // field hides statically, prints 1
        System.out.println(((Bot) ref).tag);// down-cast reveals 3
        System.out.println(Mid.tag);        // static shadow chain prints 2
    }
}
