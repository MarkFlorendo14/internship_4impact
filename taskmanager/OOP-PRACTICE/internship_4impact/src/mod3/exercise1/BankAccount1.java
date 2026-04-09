package exercise1;

public class BankAccount1 {
    String accountHolder;
    double balance;

    public BankAccount1 (String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount){
        System.out.println("Hello, " +  accountHolder + ". " + "You have deposited: " + amount );
        amount += balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("You don't have enough balance to withdraw this amount!");
        } else {
            System.out.println("You have withdrawn: " + amount);
        }
    }

    public void accountStatus() {
        System.out.println("\n       *** Account status: ***");
        System.out.println("      Account Holder: " + accountHolder);
        System.out.println("      Available Balance: " + balance);
    }
}
