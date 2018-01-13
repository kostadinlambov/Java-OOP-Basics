package p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static Map<String, Person> personMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] tokens = reader.readLine().split("\\s+");

            if("End".equalsIgnoreCase(tokens[0])){
                break;
            }
            readInput(tokens);
        }

        String nameToPrint = reader.readLine();

        Person personToPrint = personMap.get(nameToPrint);
        System.out.print(personToPrint);
    }

    private static void readInput(String[] tokens) {
        String personName = tokens[0];
        if(!personMap.containsKey(personName)){
            personMap.put(personName, new Person(personName));
        }

        Person person = personMap.get(personName);

        switch(tokens[1]){
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                Company company = new Company(companyName, department, salary);
                person.setCompany(company);
                break;
            case "pokemon":
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                person.getPokemon().add(pokemon);
                break;
            case "parents":
                String parentName = tokens[2];
                String parentBirthday = tokens[3];

                Parents parents = new Parents(parentName, parentBirthday);
                person.getParent().add(parents);
                break;
            case "children":
                String childName = tokens[2];
                String childBirthday = tokens[3];

                Children children = new Children(childName, childBirthday);
                person.getChildren().add(children);
                break;
            case "car":
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);

                Car car = new Car(carModel, carSpeed);
                person.setCar(car);
                break;
        }

        personMap.put(personName, person);
    }
}
