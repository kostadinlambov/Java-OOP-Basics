package p07_Car_Salesman;

class Engine {

    private static final int default_DISPLACEMENT_VALUE = 0;
    private static final String default_EFFICIENCY_VALUE = "n/a";

    private String engineModel;
    private int power;
    private int displacement;
    private String efficiency;


    Engine(String engineModel, int power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = default_DISPLACEMENT_VALUE;
        this.efficiency = default_EFFICIENCY_VALUE;
    }

    Engine(String engineModel, int power, int displacement) {
        this(engineModel, power);
        this.displacement = displacement;
        this.efficiency = default_EFFICIENCY_VALUE;
    }

    Engine(String engineModel, int power, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
        this.displacement = default_DISPLACEMENT_VALUE;
    }

    Engine(String engineModel, int power, int displacement, String efficiency) {
        this(engineModel, power, displacement);
        this.efficiency = efficiency;
    }

    String getEngineModel() {
        return this.engineModel;
    }

    int getPower() {
        return this.power;
    }

    int getDisplacement() {
        return this.displacement;
    }

    String getEfficiency() {
        return this.efficiency;
    }
}
