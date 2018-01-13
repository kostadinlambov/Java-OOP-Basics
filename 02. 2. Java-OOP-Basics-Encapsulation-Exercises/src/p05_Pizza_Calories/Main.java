package p05_Pizza_Calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double totalCalories = 0.0;
        String pizzasName = null;

        for (int i = 0; i < 2; i++) {
            String[] inputLine = reader.readLine().split("\\s+");
            if ("Pizza".equalsIgnoreCase(inputLine[0])) {
                pizzasName = inputLine[1];
                int numberOfToppings = Integer.parseInt(inputLine[2]);
                try {
                    Pizza pizza = new Pizza(pizzasName, numberOfToppings);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            } else {
                String flourType = inputLine[1];
                String bakingTechnique = inputLine[2];
                double doughWeightInGrams = Double.parseDouble(inputLine[3]);
                try {
                    Dough dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);
                    totalCalories += dough.calculateCaloriesInDough();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String nameOfTopping = tokens[1];
            double weightOfTopping = Double.parseDouble(tokens[2]);
            try {
                Topping topping = new Topping(nameOfTopping, weightOfTopping);
                totalCalories += topping.calculateCaloriesInTopping();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.printf("%s - %.2f", pizzasName, totalCalories);
    }
}
