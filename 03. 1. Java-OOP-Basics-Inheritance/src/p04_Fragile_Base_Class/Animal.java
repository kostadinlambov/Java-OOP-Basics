package p04_Fragile_Base_Class;

import java.util.List;

class Animal {
    protected List<Food> foodEaten;

    public Animal(List<Food> foods) {
        this.foodEaten = foods;
    }

    public final void eat (Food food){
        this.foodEaten.add(food);

    }

    public void eatAll(Food[] foods){
        for (Food food : foods) {
            this.eat(food);
        }
    }
}
