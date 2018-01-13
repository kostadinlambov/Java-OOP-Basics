package p06_Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> carsMap = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tiresList = new ArrayList<>();
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Collections.addAll(tiresList, tire1, tire2, tire3, tire4);

            Car car = new Car(model, engine, cargo, tiresList);
            carsMap.putIfAbsent(model, car);
        }

        String command = reader.readLine();

        if ("fragile".equalsIgnoreCase(command)) {
            carsMap.values().stream()
                    .filter(car -> car.getTires().stream().mapToDouble(Tire::getTirePressure).anyMatch(x -> x < 1)
                            && car.getCargo().getCargoType().equalsIgnoreCase("fragile"))
                    .forEach(x ->System.out.println(x.model));
        } else if ("flamable".equalsIgnoreCase((command))) {
            carsMap.values().stream()
                    .filter(car -> car.getCargo().getCargoType().equalsIgnoreCase("flamable")
                            && car.getEngine().getEnginePower() > 250)
                    .forEach(x -> System.out.println(x.model));
        }
    }
}
