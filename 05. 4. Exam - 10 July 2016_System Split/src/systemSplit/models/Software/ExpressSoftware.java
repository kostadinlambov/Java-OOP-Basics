package systemSplit.models.Software;

public class ExpressSoftware extends SoftwareComponent {
    private static final String TYPE_COMPONENT = "Express";

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, TYPE_COMPONENT, memoryConsumption, capacityConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    protected int getCapacity() {
        return super.getCapacityConsumption();
    }

    @Override
    protected int getMemory() {
        return super.getMemoryConsumption() * 2;
    }
}
