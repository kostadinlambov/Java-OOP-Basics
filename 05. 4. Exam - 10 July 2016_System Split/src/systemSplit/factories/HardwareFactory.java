package systemSplit.factories;

import systemSplit.models.hardware.HeavyHardware;
import systemSplit.models.hardware.PowerHardware;

public class HardwareFactory {

    private HardwareFactory() {
    }

    public static PowerHardware createPowerHardware(String name, int capacity, int memory) {
        return new PowerHardware(name, capacity, memory);
    }

    public static HeavyHardware createHeavyHardware(String name, int capacity, int memory) {
        return new HeavyHardware(name, capacity, memory);
    }
}
