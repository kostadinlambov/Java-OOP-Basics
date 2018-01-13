package p03_Bank_Account_Test_Client;

public class BankAccount {

    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount = 0;

    private int id;
    private double balance;

    BankAccount(){
        this.id = ++bankAccountCount;
    }

    static void setInterestRate(double interest){
        BankAccount.rate = interest;
    }

    double getInterestRate(double years){
        return BankAccount.rate * years  * this.balance;
    }

    void deposit(double amount){
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id , this.balance);
    }
}
