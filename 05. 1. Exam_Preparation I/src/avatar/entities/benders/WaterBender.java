package avatar.entities.benders;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, long power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getBenderTotalPower(){
        return  super.getPower()* this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("Water Bender: %s, Power: %d, Water Clarity: %.2f",
                super.getName(), super.getPower(), this.waterClarity);
    }
}
