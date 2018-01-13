package Demo.LiveDemo.light;

import Demo.LiveDemo.LightBeer;

public class BlondeAle extends LightBeer{

    private static final String BEER_STYLE = "Mild math!";

    public BlondeAle(Double percentage) {
        super(percentage, BEER_STYLE);
    }
}
