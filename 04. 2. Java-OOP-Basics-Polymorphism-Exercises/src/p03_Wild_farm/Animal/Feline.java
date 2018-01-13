package p03_Wild_farm.Animal;

import p03_Wild_farm.Food.Food;

public abstract class Feline extends Mammal {
    protected Feline(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        super.makeSound();
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
