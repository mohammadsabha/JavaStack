import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numAccounts = 0;
    private static double totalMoney = 0.0;
    private final String accountNumber;

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = generateAccountNumber();
        numAccounts++;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        long accountNumber = random.nextLong();
        return Long.toString(accountNumber);
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(String accountType, double amount) {
        if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        }
        totalMoney += amount;
    }

    public void withdraw(String accountType, double amount) {
        if (accountType.equalsIgnoreCase("checking")) {
            if (checkingBalance >= amount) {
                checkingBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else if (accountType.equalsIgnoreCase("savings")) {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
                totalMoney -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        }
    }

    public static double getTotalMoneyInBank() {
        return totalMoney;
    }

    public String toString() {
        return "Account Number: " + accountNumber + "\nChecking Balance: " + checkingBalance + "\nSavings Balance: " + savingsBalance;
    }
}
