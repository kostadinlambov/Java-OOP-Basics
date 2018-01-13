package systemSplit.models.hardware;

public class PowerHardware extends HardwareComponent {

    private static final String TYPE_COMPONENT = "Power";

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, TYPE_COMPONENT, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity - ((maximumCapacity * 3) / 4));
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory + ((maximumMemory * 3) / 4));
    }

    @Override
    protected int getCapacity() {
        return super.getMaximumCapacity() - ((super.getMaximumCapacity() * 3) / 4);
    }

    @Override
    protected int getMemory() {
        return super.getMaximumMemory() + ((super.getMaximumMemory() * 3) / 4);
    }
}