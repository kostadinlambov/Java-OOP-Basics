package p06_Raw_Data;

class Engine {
    private int engineSpeed;
    private int enginePower;

    Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    int getEnginePower() {
        return this.enginePower;
    }
}
