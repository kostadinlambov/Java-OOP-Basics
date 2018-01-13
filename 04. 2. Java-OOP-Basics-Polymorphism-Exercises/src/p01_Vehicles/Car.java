package p01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    private static final double CAR_FUEL_CONSUMPTION_SUMMER_COEFFICIENT = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void drive(double distance) {
        double distanceAbleToTravel = this.getFuelQuantity() / (this.getFuelConsumption() +
                CAR_FUEL_CONSUMPTION_SUMMER_COEFFICIENT);
        DecimalFormat df = new DecimalFormat("#.##");
        if (distanceAbleToTravel >= distance) { this.setFuelQuantity(this.getFuelQuantity() -
                (this.getFuelConsumption() + CAR_FUEL_CONSUMPTION_SUMMER_COEFFICIENT) * distance);
            System.out.printf("Car travelled %s km%n", df.format(distance));
        }else{
            System.out.println("Car needs refueling");
        }
    }

    @Override
    protected void refueling(double litersToFuel) {
        this.setFuelQuantity(litersToFuel + this.getFuelQuantity());
    }
}
