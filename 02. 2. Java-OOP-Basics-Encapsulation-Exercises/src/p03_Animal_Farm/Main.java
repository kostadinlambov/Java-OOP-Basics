package p03_Animal_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try{
            Chicken chicken = new Chicken(name, age);
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.",
                    name, age, chicken.getProductPerDay());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
