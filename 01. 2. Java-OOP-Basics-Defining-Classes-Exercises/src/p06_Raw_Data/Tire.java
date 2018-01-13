package p06_Raw_Data;

class Tire {
    private double tirePressure;
    private int tireAge;

    Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    double getTirePressure() {
        return tirePressure;
    }
}
