import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Deposit must be positive.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void showHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account acc = new Account("12345", "mamatha", 1000.0);

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Current Balance: " + acc.getBalance());
                    break;

                case 4:
                    acc.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
