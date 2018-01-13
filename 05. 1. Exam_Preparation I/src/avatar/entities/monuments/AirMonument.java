package avatar.entities.monuments;

public class AirMonument extends Monument {
    private long airAffinity;

    public AirMonument(String name, long airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public long getMonumentAffinity() {
        return this.airAffinity;
    }


    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d",
                super.getName(), this.airAffinity);
    }
}
