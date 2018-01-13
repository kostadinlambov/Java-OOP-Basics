package Demo.LiveDemo.red;

import Demo.LiveDemo.RedBeer;

public class BrownAle extends RedBeer{
    private static  final String BEER_STYLE = "Caramel and Coffee flavour";

    public BrownAle( Double percentage) {
        super(percentage, BEER_STYLE);
    }

    public void throwBeer(){
        System.out.println("You throwed a beer!");
    }
}
