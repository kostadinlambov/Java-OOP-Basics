package p04_Fragile_Base_Class;

public class Main {
    public static void main(String[] args) {

        Predator p = new Predator();

        p.feed(new Food());
        System.out.println(p.getHealth());

        p.eatAll(new Food[] {new Food(), new Food()});
        System.out.println(p.getHealth());
    }
}
