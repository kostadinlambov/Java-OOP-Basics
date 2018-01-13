package systemSplit.factories;

import systemSplit.models.Software.ExpressSoftware;
import systemSplit.models.Software.LightSoftware;

public class SoftwareFactory {

    private SoftwareFactory() {
    }

    public static ExpressSoftware createExpressSoftware(String name, int capacity, int memory) {
        return new ExpressSoftware(name, capacity, memory);
    }

    public static LightSoftware createLightSoftware(String name, int capacity, int memory) {
        return new LightSoftware(name, capacity, memory);
    }
}
