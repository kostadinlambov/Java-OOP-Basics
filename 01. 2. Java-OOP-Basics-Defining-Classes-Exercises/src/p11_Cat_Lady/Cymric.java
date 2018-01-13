package p11_Cat_Lady;

public class Cymric extends Cat{

    private double lengthFur;

    public Cymric(String name, String type, double lengthFur) {
        super(name, type);
        this.lengthFur = lengthFur;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.lengthFur);
    }
}
