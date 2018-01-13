package p03_Wild_farm;

import p03_Wild_farm.Animal.*;
import p03_Wild_farm.Food.Food;
import p03_Wild_farm.Food.Meat;
import p03_Wild_farm.Food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animalsList = new ArrayList<>();

        while (true) {
            String animalInputLine = reader.readLine();
            if ("End".equalsIgnoreCase(animalInputLine)) {
                break;
            }

            String foodInputLine = reader.readLine();

            Food food = createFood(foodInputLine);
            Animal animal = animalCreator(animalInputLine, food);

            try{
                animal.makeSound();
                animal.eat(food);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }

            animalsList.add(animal);
        }

        for (Animal animal : animalsList) {
            System.out.println(animal);
        }
    }

    private static Food createFood(String foodInputLine) {
        String[] foodTokens = foodInputLine.split("\\s+");

        String foodType = foodTokens[0];
        Integer quantity = Integer.parseInt(foodTokens[1]);

        switch (foodType){
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
        }

        return null;
    }

    private static Animal animalCreator(String animalInputLine, Food food) {
        String[] animalTokens = animalInputLine.split("\\s+");

        String animalType = animalTokens[0];
        String animalName = animalTokens[1];
        Double animalWeight = Double.parseDouble(animalTokens[2]);
        String animalLivingRegion = animalTokens[3];

        switch (animalType) {
            case "Cat":
                String catBreed = animalTokens[4];
                return new Cat(animalType, animalName, animalWeight, food.getQuantity(), animalLivingRegion, catBreed);
            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, food.getQuantity(), animalLivingRegion);
            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, food.getQuantity(), animalLivingRegion);
            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, food.getQuantity(), animalLivingRegion);
        }

        return null;
    }
}
