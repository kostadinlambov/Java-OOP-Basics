package p11_Cat_Lady;

public abstract class Cat {
    private String name;
    private String type;

    protected Cat(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.type + " " + this.name;
    }
}
