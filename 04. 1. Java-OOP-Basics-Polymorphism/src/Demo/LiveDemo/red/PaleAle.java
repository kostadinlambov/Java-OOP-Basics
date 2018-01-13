package Demo.LiveDemo.red;

import Demo.LiveDemo.RedBeer;

public class PaleAle extends RedBeer {
    private static  final String BEER_STYLE = "Robust hop aroma";

    public PaleAle(Double percentage) {
        super(percentage, BEER_STYLE);
    }
}
