package p03_Wild_farm.Animal;

import p03_Wild_farm.Food.Food;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private static final String SOUND = "Meowwww";

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight,
               Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), this.breed,
                df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
