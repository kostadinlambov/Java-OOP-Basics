package app.entities.animals;

public class Dog extends Animal {
    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.setAmountOfCommands(amountOfCommands);
    }


    public Dog(String name, int age,int amountOfCommands, String adoptionCenter) {
        super(name, age, adoptionCenter);
        this.amountOfCommands = amountOfCommands;
    }

    private void setAmountOfCommands(int amountOfCommands) {
        this.amountOfCommands = amountOfCommands;
    }


    public int getAmountOfCommands() {
        return this.amountOfCommands;
    }
}
