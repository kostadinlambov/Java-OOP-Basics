package p03_Wild_farm.Animal;

import p03_Wild_farm.Food.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight,
                  Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }


    @Override
    public void makeSound() {
    }

    @Override
    public void eat(Food food) {
    }
}
