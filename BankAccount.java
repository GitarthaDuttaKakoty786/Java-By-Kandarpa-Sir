public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        this.balance += amount;
        System.out.printf("Deposited: $%.2f. Current balance: $%.2f%n", amount, this.balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        System.out.printf("Withdrew: $%.2f. Current balance: $%.2f%n", amount, this.balance);
        return true;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC001", "Alice Smith", 1000.00);
        account1.deposit(250.50);
        account1.withdraw(300.00);
        System.out.printf("Final balance for Account %s: $%.2f%n", account1.getAccountNumber(), account1.getBalance());

        BankAccount account2 = new BankAccount("ACC002", "Bob Johnson");
        account2.deposit(500.00);
        account2.withdraw(150.75);
        System.out.printf("Final balance for Account %s: $%.2f%n", account2.getAccountNumber(), account2.getBalance());
    }
}
