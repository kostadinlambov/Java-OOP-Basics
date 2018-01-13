package p07_Car_Salesman;

class Car {

    private static final int default_WEIGHT_VALUE = 0;
    private static final String default_COLOR_VALUE = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = default_WEIGHT_VALUE;
        this.color = default_COLOR_VALUE;
    }

    Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = default_COLOR_VALUE;
    }

    Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
        this.weight = default_WEIGHT_VALUE;
    }

    Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    Engine getEngine() {
        return this.engine;
    }

    String getModel() {
        return this.model;
    }

    int getWeight() {
        return this.weight;
    }

    String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getModel() + ":").append("\n  ");
        sb.append(this.getEngine().getEngineModel()).append(":\n    ");
        sb.append("Power: ").append(this.getEngine().getPower()).append("\n    ");
        if (this.getEngine().getDisplacement() > 0) {
            sb.append("Displacement: ").append(this.getEngine().getDisplacement()).append("\n    ");
        } else {
            sb.append("Displacement: n/a").append("\n    ");
        }
        sb.append("Efficiency: ").append(this.getEngine().getEfficiency()).append("\n  ");
        if (this.getWeight() > 0) {
            sb.append("Weight: ").append(this.getWeight()).append("\n  ");
        } else {
            sb.append("Weight: n/a").append("\n  ");
        }
        sb.append("Color: ").append(this.getColor());

        return sb.toString();
    }
}
