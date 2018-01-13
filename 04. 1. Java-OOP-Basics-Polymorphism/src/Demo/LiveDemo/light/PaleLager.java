package Demo.LiveDemo.light;

import Demo.LiveDemo.LightBeer;

public class PaleLager extends LightBeer {
    private static final String BEER_STYLE = "Higly carbonized";

    public PaleLager(Double percentage) {
        super(percentage, BEER_STYLE);
    }
}
