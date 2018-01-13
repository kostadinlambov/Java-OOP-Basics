package app.entities.animals;

import app.entities.centers.AdoptionCenter;

public abstract class Animal {

    private String name;
    private int age;
    private boolean cleansingStatus;
    private String adoptionCenter;

    protected Animal(String name, int age){
        this.setName(name);
        this.setAge(age);
        this.setCleansingStatus();
    }

    public Animal(String name, int age, String adoptionCenter) {
        this(name, age);
        this.adoptionCenter = adoptionCenter;
    }

    public void setCleansingStatus(boolean cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }

    public void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    private void setCleansingStatus(){
        this.cleansingStatus = false;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isCleansingStatus() {
        return this.cleansingStatus;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void cleanse(){
        this.cleansingStatus = true;
    }

    public void removeAnimal(Animal animal){

    }

    @Override
    public String toString() {
        return this.name;
    }
}
