package avatar.entities.monuments;

public class FireMonument extends Monument {
    private long fireAffinity;

    public FireMonument(String name, long fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public long getMonumentAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d",
                super.getName(), this.fireAffinity);
    }
}
