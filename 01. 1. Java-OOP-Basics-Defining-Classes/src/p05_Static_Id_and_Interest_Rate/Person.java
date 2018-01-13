package p01_Bank_Account_Class;

import p05_Static_Id_and_Interest_Rate.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccount> accounts;


    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    Person(String name, int age, List<BankAccount> accounts) {
        this(name, age);
        this.accounts = accounts;

    }

    public double getBalance() {
        return this.accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}
