package exercise5;

public class bankAccount3 {
    private String accountHolder;
    private double balance;


    public bankAccount3(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void setBalance(double balance){
        if (balance <= 0) {
           System.out.println("Balance cannot be Zero/Negative!");
           return;
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        double initialBalance = balance;
        System.out.println("\n Hello, " + accountHolder + ", your initial balance is: " + balance);
        System.out.println(" You have deposited: " + amount);
        balance += amount;
    }

    public void withdraw(double amount, String reason) {
        if (amount > balance) {
            System.out.println("\nYou don't have enough balance to withdraw this amount!");
            System.out.println("----->  Amount tendered: " + amount);
            System.out.println("----->  Balance available: " + balance);
        } else {
            double initialBalance = balance;
            System.out.println("\n    Hello " + accountHolder + ". \n    Your initial balance is: " + initialBalance);
            System.out.println("    Withdrawal reason : " + " ' " + reason + " ' ");
            System.out.println("    You have withdrawn: " + amount);
            balance -= amount;
            System.out.print("    Your remaining balance is: " + balance + "\n");
        }
    }

    public void accountStatus() {
        System.out.println("\n       *** Account status: ***");
        System.out.println("      Account Holder: " + accountHolder);
        System.out.println("      Available Balance: " + balance);
    }
}
