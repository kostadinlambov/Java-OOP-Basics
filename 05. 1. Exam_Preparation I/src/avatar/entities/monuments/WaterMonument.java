package avatar.entities.monuments;

public class WaterMonument extends Monument {
    private long waterAffinity;

    public WaterMonument(String name, long waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public long getMonumentAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d",
                super.getName(), this.waterAffinity);
    }
}
