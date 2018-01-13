package Test_p07;

public class Car {
    private final static String DEFAULT_WEIGHT = "n/a";
    private final static String DEFAULT_COLOR = "n/a";

    private String carModel;
    private Engine engine;
    private String weight;
    private String colors;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.colors = DEFAULT_COLOR;
    }

    public Car(String carModel, Engine engine, String colors) {
        this(carModel, engine);
        this.weight = DEFAULT_WEIGHT;
        this.colors = colors;
    }

    public Car(String carModel, Engine engine, Integer weight) {
        this(carModel, engine);
        this.weight = String.valueOf(weight);
        this.colors = DEFAULT_COLOR;
    }

    public Car(String carModel, Engine engine, Integer weight, String colors) {
        this(carModel, engine, colors);
        this.weight = String.valueOf(weight);
    }

    public String getCarModel() {
        return this.carModel;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColors() {
        return this.colors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(carModel + ":\n");
        sb.append("  " + getEngine().getEngineModel() + ":" + "\n");
        sb.append("    Power: " + getEngine().getPower() + "\n");
        sb.append("    Displacement: " + getEngine().getDisplacement() + "\n");
        sb.append("    Efficiency: " + getEngine().getEfficiency() + "\n");
        sb.append("  Weight: " + weight + "\n");
        sb.append("  Color: " + colors);
        return sb.toString();
    }
}