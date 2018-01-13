package p05_Pizza_Calories;

import java.util.*;

class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weightInGrams;

    private static final Map<String, Double> providedFlourTypesMap;

    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("White", 1.5);
        aMap.put("Wholegrain", 1.0);
        providedFlourTypesMap = Collections.unmodifiableMap(aMap);
    }

    private static final Map<String, Double> providedBakingTechniquesMap;

    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("Crispy", 0.9);
        aMap.put("Chewy", 1.1);
        aMap.put("Homemade", 1.0);
        providedBakingTechniquesMap = Collections.unmodifiableMap(aMap);
    }

    Dough(String flourType, String bakingTechnique, double weightInGrams) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if (!providedFlourTypesMap.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!providedBakingTechniquesMap.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    double calculateCaloriesInDough() {
        return 2 * this.weightInGrams * providedFlourTypesMap.get(this.flourType) *
                providedBakingTechniquesMap.get(this.bakingTechnique);
    }
}
