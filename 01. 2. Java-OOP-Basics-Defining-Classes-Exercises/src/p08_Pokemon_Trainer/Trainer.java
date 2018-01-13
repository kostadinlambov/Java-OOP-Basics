package p08_Pokemon_Trainer;

import java.util.List;

class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonsList;

    Trainer(String name, List<Pokemon> pokemonsList) {
        this.name = name;
        this.pokemonsList = pokemonsList;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    List<Pokemon> getPokemonsList() {
        return this.pokemonsList;
    }
}
