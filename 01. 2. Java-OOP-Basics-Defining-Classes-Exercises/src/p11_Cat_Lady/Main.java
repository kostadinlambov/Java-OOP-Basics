package p11_Cat_Lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String line;
        while(true){

            if("end".equalsIgnoreCase(line = reader.readLine())){
                break;
            }

            String[] tokens = line.split("\\s+");

            Cat cat = null;
            switch (tokens[0]){
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(tokens[1], tokens[0], Double.parseDouble(tokens[2]));
                    break;
                case "Siamese":
                    cat = new Siamese(tokens[1], tokens[0], Double.parseDouble(tokens[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(tokens[1], tokens[0], Double.parseDouble(tokens[2]));
                    break;
            }

            cats.putIfAbsent(cat.getName(), cat);
        }
        System.out.println(cats.get(reader.readLine()));
    }
}
