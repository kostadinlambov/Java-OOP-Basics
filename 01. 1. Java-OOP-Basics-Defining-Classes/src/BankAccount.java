import java.util.LinkedHashMap;

class BankAccount {
    public static int BankAccountsCount;
    private int id = 5;
    private double balance = 0.0;


    BankAccount() {
    }

    BankAccount(int id) {
        this.id = id;
        this.balance = balance;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f",
                this.id, this.balance);
    }
}
