package Demo.LiveDemo;

public abstract class DarkBeer extends Beer {
    private static final String BEER_COLOR = "Dark";

    public DarkBeer(Double percentage, String style) {
        super(BEER_COLOR, percentage, style);
    }
}
