package Demo.LiveDemo;

public abstract class RedBeer extends Beer {

    private static  final String BEER_COLOR = "Red";

    public RedBeer(Double percentage, String style) {
        super(BEER_COLOR, percentage, style);
    }
}
