package avatar.entities.benders;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, long power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    public double getBenderTotalPower(){
        return  super.getPower()* this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                super.getName(), super.getPower(), this.heatAggression);
    }
}
