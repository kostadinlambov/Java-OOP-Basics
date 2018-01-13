package p04_Mordors_Cruelty_Plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> foodsList =
                new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        Wizard wizard = new Wizard();

        int happinessPoints = wizard.getHappinessPoints(foodsList);

        if(happinessPoints < -5){
            System.out.println(happinessPoints);
            System.out.println("Angry");
        }else if(happinessPoints <= 0){
            System.out.println(happinessPoints);
            System.out.println("Sad");
        }else if(happinessPoints <= 15){
            System.out.println(happinessPoints);
            System.out.println("Happy");
        }else{
            System.out.println(happinessPoints);
            System.out.println("JavaScript");
        }
    }
}
