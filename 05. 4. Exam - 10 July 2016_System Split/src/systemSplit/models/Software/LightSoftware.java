package systemSplit.models.Software;

public class LightSoftware extends SoftwareComponent {

    private static final String TYPE_COMPONENT = "Light";

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE_COMPONENT, memoryConsumption, capacityConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - memoryConsumption / 2);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + capacityConsumption / 2);
    }

    @Override
    protected int getCapacity() {
        return super.getCapacityConsumption() + super.getCapacityConsumption() / 2;
    }

    @Override
    protected int getMemory() {
        return super.getMemoryConsumption() - super.getMemoryConsumption() / 2;
    }
}
