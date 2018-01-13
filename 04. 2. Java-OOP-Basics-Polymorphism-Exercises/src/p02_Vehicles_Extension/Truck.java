package p02_Vehicles_Extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    private static final double TRUCK_FUEL_CONSUMPTION_SUMMER_COEFFICIENT = 1.6;
    private static final double TRUCK_REFUELING_COEFFICIENT = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    @Override
    protected void drive(double distance) {
        double distanceAbleToTravel = this.getFuelQuantity() / (this.getFuelConsumption() +
                TRUCK_FUEL_CONSUMPTION_SUMMER_COEFFICIENT);
        DecimalFormat df = new DecimalFormat("#.##");
        if (distanceAbleToTravel >= distance) {
            this.setFuelQuantity(this.getFuelQuantity()
                    - (this.getFuelConsumption() + TRUCK_FUEL_CONSUMPTION_SUMMER_COEFFICIENT) * distance);
            System.out.printf("Truck travelled %s km%n", df.format(distance));
        }else{
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    protected void refueling(double litersToFuel) {
        if (litersToFuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(litersToFuel + getFuelQuantity() > this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(litersToFuel * TRUCK_REFUELING_COEFFICIENT + this.getFuelQuantity());
    }

    @Override
    protected void driveEmpty(double distance) {
    }
}
