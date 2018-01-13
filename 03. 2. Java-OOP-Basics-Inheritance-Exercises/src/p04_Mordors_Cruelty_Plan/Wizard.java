package p04_Mordors_Cruelty_Plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Wizard {
    private static final Map<String, Integer> foodsIndexMap =
            new HashMap<String, Integer>() {{
                put("cram", 2);
                put("lembas", 3);
                put("apple", 1);
                put("melon", 1);
                put("honeycake", 5);
                put("mushrooms", -10);
            }};

    int getHappinessPoints(List<String> foods) {
        int happinessPoints = 0;
        for (String food : foods) {
            happinessPoints += eatFood(food);
        }
        return happinessPoints;
    }

    private int eatFood(String food) {
        try {
            return foodsIndexMap.get(food.toLowerCase());
        } catch (Exception e) {
            return -1;
        }
    }
}
