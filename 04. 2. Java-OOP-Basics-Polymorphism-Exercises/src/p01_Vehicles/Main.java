package p01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(carTokens[1]);
        double fuelConsumptionCar = Double.parseDouble(carTokens[2]);
        Vehicle car  = new Car(fuelQuantityCar, fuelConsumptionCar);

        String[] truckTokens = reader.readLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(truckTokens[1]);
        double fuelConsumptionTruck = Double.parseDouble(truckTokens[2]);
        Vehicle truck  = new Truck(fuelQuantityTruck, fuelConsumptionTruck);

        int numbersOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numbersOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double distanceOrLiters = Double.parseDouble(tokens[2]);

            switch(command){
                case "Drive":
                    if("Car".equalsIgnoreCase(vehicleType)){
                        car.drive(distanceOrLiters);
                    }else{
                        truck.drive(distanceOrLiters);
                    }
                    break;

                case "Refuel":
                    if("Car".equalsIgnoreCase(vehicleType)){
                        car.refueling(distanceOrLiters);
                    }else{
                        truck.refueling(distanceOrLiters);
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
