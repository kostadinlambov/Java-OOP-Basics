package Demo.LiveDemo.dark;

import Demo.LiveDemo.DarkBeer;

public class Porter extends DarkBeer {

    private static final String BEER_STYLE = "Notes of chocolate";

    public Porter(Double percentage) {
        super(percentage, BEER_STYLE);
    }
}
