package app.factories;

import app.entities.animals.Cat;
import app.entities.animals.Dog;


public class AnimalFactory {

    private AnimalFactory() { }

    public static Dog createDog(String name, int age, int learnedCommands, String adoptionCenter) {
        return new Dog(name, age, learnedCommands, adoptionCenter);
    }

    public static Cat createCat(String name, int age, int intelligenceCoefficient, String adoptionCenter) {
        return new Cat(name, age, intelligenceCoefficient, adoptionCenter);
    }
}
