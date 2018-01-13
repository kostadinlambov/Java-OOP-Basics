package p03_Opinion_Poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> personSet = new TreeSet<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {


            String[] inputLine = reader.readLine().split("\\s+");

            String name = inputLine[0];
            int age = Integer.parseInt(inputLine[1]);

            Person person = new Person(name, age);
            personSet.add(person);
        }

        personSet.stream()
                .filter(x -> x.getAge() > 30)
                .forEach(x -> System.out.println(x.getName() + " - " + x.getAge()));

    }
}
