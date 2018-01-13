package app.core;

import app.entities.animals.Animal;
import app.entities.animals.Cat;
import app.entities.animals.Dog;
import app.entities.centers.AdoptionCenter;
import app.entities.centers.CleansingCenter;
import app.factories.AnimalFactory;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String, AdoptionCenter> adoptionCentersMap;
    private Map<String, CleansingCenter> cleansingCentersMap;
    private List<Animal> cleansedAnimals;
    private List<Animal> adoptedAnimals;

    public AnimalCenterManager() {
        this.cleansingCentersMap = new TreeMap<>();
        this.adoptionCentersMap = new TreeMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }


    public void registerCleansingCenter(String name) {
        CleansingCenter center = new CleansingCenter(name);
        this.cleansingCentersMap.putIfAbsent(name, center);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter center = new AdoptionCenter(name);
        this.adoptionCentersMap.putIfAbsent(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog animal = AnimalFactory.createDog(name, age, learnedCommands, adoptionCenterName);
        adoptionCentersMap.get(adoptionCenterName).addAnimal(animal);

    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat animal = AnimalFactory.createCat(name, age, intelligenceCoefficient, adoptionCenterName);
        adoptionCentersMap.get(adoptionCenterName).addAnimal(animal);
    }


    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCentersMap.get(cleansingCenterName);
        this.adoptionCentersMap.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }


    public void cleanse(String cleansingCenterName) {

        CleansingCenter cleansingCenter = this.cleansingCentersMap.get(cleansingCenterName);
        List<Animal> cleansedAnimalsList = cleansingCenter.cleanse();

        for (String name : adoptionCentersMap.keySet()) {
            for (Animal animal : cleansedAnimalsList) {
                if (name.equals(animal.getAdoptionCenter())) {
                    adoptionCentersMap.get(name).addAnimal(animal);
                }
            }
        }
        this.cleansedAnimals.addAll(cleansedAnimalsList);
    }


    public void adopt(String adoptionCenterName) {

        List<Animal> animalsToRemove = cleansedAnimals.stream()
                .filter(x -> x.getAdoptionCenter().equals(adoptionCenterName))
                .collect(Collectors.toList());

        adoptedAnimals.addAll(animalsToRemove);
        adoptionCentersMap.get(adoptionCenterName).removeAnimals(animalsToRemove);

    }

    private String sortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        animals.sort(Comparator.comparing(Animal::getName));

        return String.join(", ", animals
                .stream()
                .map(Animal::getName)
                .collect(Collectors.toList()));
    }

    public void printStatistics() {
        StringBuilder sb = new StringBuilder();

        int countReadyToAdopt = 0;
        for (AdoptionCenter adoptionCenter : adoptionCentersMap.values()) {
            countReadyToAdopt += adoptionCenter.getAnimals().stream().filter(Animal::isCleansingStatus).count();
        }

        int awaitingForClean = 0;
        for (CleansingCenter cleansingCenter : cleansingCentersMap.values()) {
            awaitingForClean += cleansingCenter.getAnimals().stream().filter(x -> !x.isCleansingStatus()).count();
        }

        sb.append("Paw Incorporative Regular Statistics").append(System.lineSeparator());
        sb.append(String.format("Adoption Centers: %d", adoptionCentersMap.size())).append(System.lineSeparator());
        sb.append(String.format("Cleansing Centers: %d", cleansingCentersMap.size())).append(System.lineSeparator());
        sb.append(String.format("Adopted Animals: %s",sortedAnimals(adoptedAnimals)))
                .append(System.lineSeparator());
        sb.append(String.format("Cleansed Animals: %s", String.join(", ",
                sortedAnimals(cleansedAnimals))))
                .append(System.lineSeparator());
        sb.append(String.format("Animals Awaiting Adoption: %d", countReadyToAdopt)).append(System.lineSeparator());


        sb.append(String.format("Animals Awaiting Cleansing: %d", awaitingForClean)).append(System.lineSeparator());

        System.out.println(sb.toString());

    }
}
