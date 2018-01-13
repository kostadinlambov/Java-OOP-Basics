package p05_Pizza_Calories;

import java.util.*;

class Topping {
    private String toppingType;
    private double weightInGrams;

    private static final Map<String, Double> providedTypesOfToppingsMap;

    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("Meat", 1.2);
        aMap.put("Veggies", 0.8);
        aMap.put("Cheese", 1.1);
        aMap.put("Sauce", 0.9);
        providedTypesOfToppingsMap = Collections.unmodifiableMap(aMap);
    }

    Topping(String toppingType, double weightInGrams) {
        setToppingType(toppingType);
        setWeightInGrams(weightInGrams);
    }

    private void setToppingType(String toppingType) {
        if (!providedTypesOfToppingsMap.containsKey(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weightInGrams = weightInGrams;
    }

    double calculateCaloriesInTopping() {
        return 2 * this.weightInGrams * providedTypesOfToppingsMap.get(this.toppingType);
    }
}
