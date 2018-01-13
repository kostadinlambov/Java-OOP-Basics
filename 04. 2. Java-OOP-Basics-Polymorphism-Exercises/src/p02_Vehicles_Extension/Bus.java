package p02_Vehicles_Extension;

import java.text.DecimalFormat;
import java.util.Collections;

public class Bus extends Vehicle{
    private static final double BUS_WITH_PEOPLE_COEFFICIENT = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption , double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void drive(double distance) {
        double distanceAbleToTravel = this.getFuelQuantity() / (this.getFuelConsumption() +
                BUS_WITH_PEOPLE_COEFFICIENT);
        DecimalFormat df = new DecimalFormat("#.##");
        if (distanceAbleToTravel >= distance) {
            this.setFuelQuantity(this.getFuelQuantity()
                    - (this.getFuelConsumption() + BUS_WITH_PEOPLE_COEFFICIENT) * distance);
            System.out.printf("Bus travelled %s km%n", df.format(distance));
        }else{
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    protected void driveEmpty(double distance) {
        double distanceAbleToTravel = this.getFuelQuantity() / (this.getFuelConsumption());
        DecimalFormat df = new DecimalFormat("#.##");
        if (distanceAbleToTravel >= distance) {
            this.setFuelQuantity(this.getFuelQuantity()
                    - (this.getFuelConsumption()) * distance);
            System.out.printf("Bus travelled %s km%n", df.format(distance));
        }else{
            System.out.println("Bus needs refueling");
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
        this.setFuelQuantity(litersToFuel + this.getFuelQuantity());
    }
}

