package p05_Static_Id_and_Interest_Rate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] inputLine = reader.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(inputLine[0])) {
                break;
            }

            String command = inputLine[0];

            switch (command) {
                case "Create":
                    createAccount();
                    break;
                case "Deposit":
                    depositSum(Integer.valueOf(inputLine[1]), Double.parseDouble(inputLine[2]));
                    break;
                case "Withdraw":
                    withdrawSum(Integer.valueOf(inputLine[1]), Double.parseDouble(inputLine[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(inputLine[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.valueOf(inputLine[1]), Double.parseDouble(inputLine[2]));
                    break;
                case "Print":
                    tryToPrint(Integer.valueOf(inputLine[1]));
                    break;
            }
        }
    }

    private static void getInterest(Integer id, double years) {
        if (accounts.containsKey(id)) {
            System.out.printf("%.2f%n", accounts.get(id).getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void tryToPrint(Integer id) {
        if (accounts.containsKey(id)) {
            System.out.println(accounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void withdrawSum(Integer id, double amount) {
        if (accounts.containsKey(id)) {
            accounts.get(id).withdraw(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositSum(Integer id, double amount) {
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount() {
        BankAccount ba = new BankAccount();
        accounts.put(ba.getId(), ba);
        System.out.printf("Account ID%d created\n", ba.getId());
    }
}
