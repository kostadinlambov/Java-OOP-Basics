package Demo.LiveDemo;


public abstract class LightBeer extends Beer {

    private static final String BEER_COLOR = "light";
    public LightBeer(Double percentage, String style) {
        super(BEER_COLOR, percentage, style);
    }
}

