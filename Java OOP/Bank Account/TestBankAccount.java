public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000.0, 500.0);
        System.out.println(account1);

        account1.deposit("checking", 200.0);
        System.out.println(account1);

        account1.withdraw("savings", 400.0);
        System.out.println(account1);

        System.out.println("Total money in bank: " + BankAccount.getTotalMoneyInBank());
    }
}
