package p04_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personsMap = new LinkedHashMap<>();
        Map<String, Product> productsMap = new LinkedHashMap<>();

        String[] personsInputLine = reader.readLine().split(";");

        for (int i = 0; i < personsInputLine.length; i++) {

            String[] tokens = personsInputLine[i].split("=");
            String name = tokens[0];
            int money = Integer.parseInt(tokens[1]);

            try{
                Person person = new Person(name, money);
                personsMap.putIfAbsent(name, person);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsInputLine = reader.readLine().split(";");

        for (int i = 0; i < productsInputLine.length; i++) {

            String[] tokens = productsInputLine[i].split("=");
            String name = tokens[0];
            int cost = Integer.parseInt(tokens[1]);

            try{
                Product product = new Product(name, cost);
                productsMap.putIfAbsent(name, product);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        while(true){

            String[] tokens = reader.readLine().split("\\s+");

            if("END".equalsIgnoreCase(tokens[0])){
                break;
            }

            String personName = tokens[0];
            String productName = tokens[1];

            Person person = personsMap.get(personName);
            Product product = productsMap.get(productName);

            person.buyingProduct(product);
        }

        for (Person person : personsMap.values()) {
            System.out.println(person);
        }
    }
}
