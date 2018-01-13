package p06_Football_Team_Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, FootballTeam> teams = new HashMap<>();

        String line;
        while (true) {

            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(";");

            String teamName;
            switch (tokens[0]) {
                case "Team":
                    FootballTeam team = new FootballTeam(tokens[1]);
                    teams.putIfAbsent(team.getName(), team);
                    break;
                case "Add":
                    try {
                        addPlayerInTeam(teams, tokens);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Remove":
                    teamName = tokens[1];
                    String playerName = tokens[2];

                    try {
                        teams.get(teamName).removePlayer(playerName);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "Rating":
                    teamName = tokens[1];
                    if (teams.containsKey(teamName)) {
                        System.out.println(String.format("%s - %.0f", teamName, teams.get(teamName).getRating()));
                    } else {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                    }
                    break;
            }
        }
    }

    private static void addPlayerInTeam(Map<String, FootballTeam> teams, String[] tokens) {
        String teamName = tokens[1];
        if (teams.containsKey(teamName)) {
            Player player = new Player(tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]),
                    Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));

            teams.get(teamName).addPlayer(player);
        } else {
            System.out.println(String.format("Team %s does not exist.", teamName));
        }
    }
}


