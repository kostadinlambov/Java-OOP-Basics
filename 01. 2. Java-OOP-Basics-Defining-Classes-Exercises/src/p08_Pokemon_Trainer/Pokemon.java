package p08_Pokemon_Trainer;

class Pokemon {

    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    String getName() {
        return this.name;
    }

    String getElement() {
        return this.element;
    }

    int getHealth() {
        return this.health;
    }

    void setName(String name) {
        this.name = name;
    }

    void setHealth(int health) {
        this.health = health;
    }
}
