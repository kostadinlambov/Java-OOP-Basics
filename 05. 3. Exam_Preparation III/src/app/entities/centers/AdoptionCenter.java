package app.entities.centers;

import app.entities.animals.Animal;
import java.util.List;
import java.util.stream.Collectors;


public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter cleansingCenter){
        List<Animal> animals =  super.getAnimals();
        List<Animal> uncleanedAnimals =  animals.stream().filter(x -> !x.isCleansingStatus()).collect(Collectors.toList());
        super.removeAnimals(uncleanedAnimals);
        cleansingCenter.addAll(uncleanedAnimals);
    }
}
