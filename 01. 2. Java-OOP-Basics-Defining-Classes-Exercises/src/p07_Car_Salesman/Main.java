package p07_Car_Salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Engine> enginesMap = new LinkedHashMap<>();
        List<Car> carsList = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfEngines; i++) {

            String[] tokens = reader.readLine().split("\\s+");

            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);

            Engine engine = null;
            switch(tokens.length){
                case 2:
                    engine = new Engine(engineModel, enginePower);
                    break;
                case 3:
                    try{
                        engine = new Engine(engineModel, enginePower, Integer.parseInt(tokens[2]));
                    }catch(Exception e){
                        engine = new Engine(engineModel, enginePower, tokens[2]);
                    }
                    break;
                case 4:
                    String displacement = tokens[2];
                    String efficiency = tokens[3];
                    engine = new Engine(engineModel, enginePower, Integer.parseInt(displacement), efficiency);
                    break;
            }
            enginesMap.putIfAbsent(engineModel, engine);
        }

        int numbersOfCars = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numbersOfCars; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String carModel = tokens[0];
            String engineModelName = tokens[1];

            Car car = null;
            switch(tokens.length){
                case 2:
                    car = new Car(carModel, enginesMap.get(engineModelName));
                    break;
                case 3:
                    try{
                        car = new Car(carModel, enginesMap.get(engineModelName), Integer.parseInt(tokens[2]));
                    }catch(Exception e){
                        car = new Car(carModel, enginesMap.get(engineModelName), tokens[2]);
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];
                    car = new Car(carModel, enginesMap.get(engineModelName), weight, color);
                    break;
            }

            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.println(car.toString());
        }
    }
}
