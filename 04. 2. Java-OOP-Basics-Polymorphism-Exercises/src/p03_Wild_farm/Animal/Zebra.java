package p03_Wild_farm.Animal;

import p03_Wild_farm.Food.Food;

import java.text.DecimalFormat;

public class Zebra extends Mammal{
    private static final String SOUND = "Zs";

    public Zebra(String animalName, String animalType,
                 Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(SOUND);
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();
        if(!foodType.equalsIgnoreCase("Vegetable")){
            setFoodEaten(0);
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", this.getAnimalType()));
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(),
                df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
