package avatar.entities.monuments;

public class EarthMonument extends Monument {
    private long earthAffinity;

    public EarthMonument(String name, long earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public long getMonumentAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("Earth Monument: %s, Earth Affinity: %d",
                super.getName(), this.earthAffinity);
    }
}
