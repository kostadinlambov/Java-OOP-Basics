package p06_Football_Team_Generator;

import java.util.HashMap;
import java.util.Map;

public class FootballTeam {
    private String name;
    private double rating;
    private Map<String, Player> playersMap;

    FootballTeam(String name) {
        setName(name);
        this.rating = 0.0;
        this.playersMap = new HashMap<>();
    }


    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }


    public double getRating() {
        if(this.playersMap.size() > 0){
            this.rating = this.playersMap.values().stream().mapToDouble(Player::statsAverageValue).average().getAsDouble();
        }
        return this.rating;

    }

    void addPlayer(Player player) {
        playersMap.putIfAbsent(player.getName(), player);
    }

    void removePlayer(String playerName) {
        if (!this.playersMap.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        this.playersMap.remove(playerName);
    }
}

