package systemSplit.models.hardware;

public class HeavyHardware extends HardwareComponent {

    private static final String TYPE_COMPONENT = "Heavy";

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, TYPE_COMPONENT, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {

        super.setMaximumCapacity(maximumCapacity  * 2);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        super.setMaximumMemory(maximumMemory - (maximumMemory / 4));
    }

    @Override
    protected int getCapacity() {
        return super.getMaximumCapacity() * 2;
    }

    @Override
    protected int getMemory() {
        return super.getMaximumMemory() - ((super.getMaximumMemory()) / 4);
    }

}
