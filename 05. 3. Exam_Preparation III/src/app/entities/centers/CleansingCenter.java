package app.entities.centers;

import app.entities.animals.Animal;

import java.util.*;

public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse(){
        List<Animal> animalsInCenter = new ArrayList<>();
        for (Animal x : super.getAnimals()) {
            x.cleanse();
            animalsInCenter.add(x);
        }

        super.removeAnimals(animalsInCenter);
        return animalsInCenter;
    }
}
