package Test_p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(reader.readLine());

        HashMap<String, Engine> cars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Engine engine = null;

            String engineModel = tokens[0];
            Integer power = Integer.parseInt(tokens[1]);

            engine = getEngine(tokens, engine, engineModel, power);

            cars.put(engineModel, engine);
        }

        Integer m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Car car = null;

            car = getCar(cars, tokens, car);

            System.out.println(car);
        }
    }

    private static Engine getEngine(String[] tokens, Engine engine, String engineModel, Integer power) {
        switch (tokens.length) {
            case 3:
                try {
                    Integer displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engineModel, power, displacement);
                } catch (Exception e) {
                    String efficiency = tokens[2];
                    engine = new Engine(engineModel, power, efficiency);
                }

                break;
            case 4:
                Integer displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
                break;
        }
        return engine;
    }

    private static Car getCar(HashMap<String, Engine> cars, String[] tokens, Car car) {
        String carModel = tokens[0];
        Engine engine = cars.get(tokens[1]);

        switch (tokens.length) {
            case 2:
                car = new Car(carModel, engine);
                break;
            case 3:
                try {
                    Integer weight = Integer.parseInt(tokens[2]);
                    car = new Car(carModel, engine, weight);
                } catch (Exception e) {
                    String color = tokens[2];
                    car = new Car(carModel, engine, color);
                }
                break;
            case 4:
                Integer weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(carModel, engine, weight, color);
                break;
        }
        return car;
    }
}