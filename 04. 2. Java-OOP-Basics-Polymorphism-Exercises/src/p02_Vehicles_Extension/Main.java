package p02_Vehicles_Extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Vehicle> vehiclesList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String inputVehicle = reader.readLine();
            Vehicle vehicle = vehicleCreator(inputVehicle);
            vehiclesList.add(vehicle);
        }

        int numbersOfCommands = Integer.parseInt(reader.readLine());

        //Engine
        for (int i = 0; i < numbersOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double distanceOrLiters = Double.parseDouble(tokens[2]);
            try {
                switch (command) {
                    case "Drive":
                        vehicleDrive(vehicleType, vehiclesList, distanceOrLiters);
                        break;
                    case "Refuel":
                        vehicleRefuel(vehicleType, vehiclesList, distanceOrLiters);
                        break;
                    case "DriveEmpty":
                        driveBusEmpty(vehicleType, vehiclesList, distanceOrLiters);
                        break;
                }
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        for (Vehicle vehicle : vehiclesList) {
            System.out.println(vehicle.toString());
        }
    }

    List<Vehicle> vehiclesList = new ArrayList<>();

    //GameManager---------------------------------------------------------------
    private static void driveBusEmpty(String vehicleType, List<Vehicle> vehiclesList, double distanceOrLiters) {
        vehiclesList.stream()
                .filter(x -> x.getClass().getSimpleName().equals(vehicleType))
                .findFirst()
                .ifPresent(x -> x.driveEmpty(distanceOrLiters));
    }

    private static void vehicleRefuel(String vehicleType, List<Vehicle> vehiclesList, double distanceOrLiters) {
        vehiclesList.stream()
                .filter(x -> x.getClass().getSimpleName().equals(vehicleType))
                .findFirst()
                .ifPresent(x -> x.refueling(distanceOrLiters));
    }

    private static void vehicleDrive(String vehicleType, List<Vehicle> vehiclesList, double distanceOrLiters) {
        vehiclesList.stream()
                .filter(x -> x.getClass().getSimpleName().equals(vehicleType))
                .findFirst()
                .ifPresent(x -> x.drive(distanceOrLiters));

    }

    private static Vehicle vehicleCreator(String inputVehicle){

        String[] tokens = inputVehicle.split(" ");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity= Double.parseDouble(tokens[3]);

        switch(vehicleType){
            case"Car" : return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case"Truck" : return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case"Bus" : return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
        return null;
    }
}
