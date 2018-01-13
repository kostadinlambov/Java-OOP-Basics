package p11_Cat_Lady;

public class StreetExtraordinaire extends Cat{

    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, String type, double decibelsOfMeows) {
        super(name, type);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}
