package p05_Online_Radio_Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongsToAdd = Integer.parseInt(reader.readLine());

        long totalTimeInSeconds = 0L;
        int countAddedSongs = 0;
        for (int i = 0; i < numberOfSongsToAdd; i++) {
            String[] tokens = reader.readLine().split(";");

            try {
                String[] songLengthArr = tokens[2].split(":");
                long minutes = Long.parseLong(songLengthArr[0]);
                long seconds = Long.parseLong(songLengthArr[1]);

                Song song = new Song(tokens[0], tokens[1], minutes, seconds);

                totalTimeInSeconds += minutes * 60 + seconds;
                countAddedSongs++;
                System.out.println("Song added.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid song length.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", countAddedSongs);
        printPlaylistLength(totalTimeInSeconds);
    }

    public static void printPlaylistLength(long totalTimeInSeconds) {

        long hours = totalTimeInSeconds / 3600;
        long reminder = totalTimeInSeconds % 3600;
        long minutes = reminder / 60;
        long seconds = reminder % 60;

        System.out.printf("Playlist length: %dh %dm %ds%n", hours, minutes, seconds);
    }
}
