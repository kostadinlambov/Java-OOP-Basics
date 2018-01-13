package avatar.entities.monuments;

public abstract class Monument {
    private String name;

    protected Monument(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public abstract long getMonumentAffinity();
}
