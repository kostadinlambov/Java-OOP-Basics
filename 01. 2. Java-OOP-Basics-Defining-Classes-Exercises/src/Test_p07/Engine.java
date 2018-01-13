package Test_p07;

import javax.print.DocFlavor;

public class Engine {
    private final static String DEFAULT_EFFICIENCY = "n/a";
    private final static String DEFAULT_DISPLACEMENT = "n/a";

    private String engineModel;
    private Integer power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, Integer power, Integer displacement) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = String.valueOf(displacement);
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine(String engineModel, Integer power, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = DEFAULT_DISPLACEMENT;
    }

    public Engine(String engineModel, Integer power, Integer displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = String.valueOf(displacement);
        this.efficiency = efficiency;
    }

    public static String getDefaultEfficiency() {
        return DEFAULT_EFFICIENCY;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public Integer getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}