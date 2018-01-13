package p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInput = reader.readLine().split("\\s+");
        String[] workerInput = reader.readLine().split("\\s+");

        try{
            Student student = new Student(studentInput[0], studentInput[1], studentInput[2]);

            Worker worker = new Worker(workerInput[0], workerInput[1],
                    Double.parseDouble(workerInput[2]),Double.parseDouble( workerInput[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());

        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
