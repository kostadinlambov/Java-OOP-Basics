package p05_Speed_Racing;

import java.text.Format;

class Car {
    private static final double DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distanceTraveled;

    Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = DEFAULT_DISTANCE_TRAVELED;
    }

    String getModel() {
        return this.model;
    }

    double getFuelAmount() {
        return this.fuelAmount;
    }

    double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    void calculateCanMoveTheDistance(int distanceToMove) {
        double reachableDistance = this.fuelAmount / this.fuelCost;
        if (reachableDistance < distanceToMove) {
            throw new IllegalStateException("Insufficient fuel for the drive");
        }
        this.distanceTraveled += distanceToMove;
        this.fuelAmount -= distanceToMove * this.fuelCost;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount,this.distanceTraveled);
    }
}
