package Demo.LiveDemo.dark;

import Demo.LiveDemo.DarkBeer;

public class Stout extends DarkBeer {

    private static final String BEER_STYLE = "Hints of coffee";

    public Stout(Double percentage) {
        super(percentage, BEER_STYLE);
    }
}
