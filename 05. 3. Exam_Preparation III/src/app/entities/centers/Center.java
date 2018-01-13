package app.entities.centers;

import app.entities.animals.Animal;

import java.util.*;

public abstract class Center {
    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.setName(name);
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public void removeAnimals(List<Animal> animalsToRemove) {
        this.animals.removeAll(animalsToRemove);
    }
    public void addAll(List<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
