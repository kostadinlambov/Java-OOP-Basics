package p09_Google;

class Pokemon {
    private String pokemonName;
    private String pokemonType;

    Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format(pokemonName + " " + pokemonType);
    }
}
