package avatar.entities.benders;

 public abstract class Bender {

    private String name;
    private long power;

    protected Bender(String name, long power) {
        this.setName(name);
        this.setPower(power);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return this.power;
    }

    protected void setPower(long power) {
        this.power = power;
    }

    public abstract double getBenderTotalPower();
}
