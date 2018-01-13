package p08_Pokemon_Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("Tournament".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            List<Pokemon> pokemonsList = new ArrayList<>();

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonsList.add(pokemon);

            if (!trainerMap.containsKey(trainerName)) {
                trainerMap.put(trainerName, new Trainer(trainerName, pokemonsList));
            } else {
                Trainer trainer = trainerMap.get(trainerName);
                trainer.getPokemonsList().add(pokemon);
                trainerMap.put(trainerName, trainer);
            }
        }

        while (true) {
            String command = reader.readLine();
            if ("End".equalsIgnoreCase(command)) {
                break;
            }
            pokemonsCheck(command, trainerMap);
        }

        LinkedHashMap<String, Trainer> sortedMap = trainerMap.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().getNumberOfBadges(),
                        a.getValue().getNumberOfBadges()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Trainer> trainer : sortedMap.entrySet()) {
            System.out.println(trainer.getKey() + " " + trainer.getValue().getNumberOfBadges() + " "
                    + trainer.getValue().getPokemonsList().size());
        }
    }

    private static void pokemonsCheck(String command, Map<String, Trainer> trainerMap) {

        for (Trainer trainer : trainerMap.values()) {
            boolean hasElement = false;
            for (Pokemon x : trainer.getPokemonsList()) {
                if (command.equalsIgnoreCase(x.getElement())) {
                    hasElement = true;
                    break;
                }
            }
            if (hasElement) {
                int currentNumberOfBadges = trainer.getNumberOfBadges();
                trainer.setNumberOfBadges(++currentNumberOfBadges);
            } else {
                for (Pokemon x : trainer.getPokemonsList()) {
                    int currentHealth = x.getHealth();
                    x.setHealth(currentHealth - 10);
                }
            }

            trainer.getPokemonsList().removeIf(x -> x.getHealth() <= 0);
        }
    }
}
