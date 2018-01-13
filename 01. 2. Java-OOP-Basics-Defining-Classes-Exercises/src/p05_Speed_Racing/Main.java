package p05_Speed_Racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> carsMap = new LinkedHashMap<>();

        int numberOfCarsToTrack = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCarsToTrack; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCost);

            carsMap.putIfAbsent(model, car);
        }

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("End".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String model = tokens[1];
            int distanceToMove = Integer.parseInt(tokens[2]);

            try{
                carsMap.get(model).calculateCanMoveTheDistance(distanceToMove);
            }catch(IllegalStateException ise){
                System.out.println(ise.getMessage());
            }
        }

        carsMap.values().forEach(System.out::println);

    }
}
