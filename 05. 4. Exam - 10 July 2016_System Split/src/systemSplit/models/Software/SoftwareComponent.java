package systemSplit.models.Software;

import systemSplit.models.Component;

public abstract class SoftwareComponent extends Component {
    private int memoryConsumption;
    private int capacityConsumption ;

    protected SoftwareComponent(String name, String type, int memoryConsumption, int capacityConsumption) {
        super(name, type);
        this.setMemoryConsumption(memoryConsumption);
        this.setCapacityConsumption(capacityConsumption);
    }

    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }
}
