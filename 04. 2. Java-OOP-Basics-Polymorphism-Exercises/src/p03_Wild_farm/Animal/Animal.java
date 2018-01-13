package p03_Wild_farm.Animal;

import p03_Wild_farm.Food.Food;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalType, String animalName, Double animalWeight, Integer foodEaten) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(foodEaten);
    }


    public String getAnimalName() {
        return this.animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return this.animalWeight;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }


    public abstract void makeSound();

    public abstract void eat(Food food);

    @Override
    public String toString() {
        return String.format("%s[%s, %.2f, %d]", this.animalType, this.animalName, this.animalWeight,
                this.foodEaten);
    }
}
