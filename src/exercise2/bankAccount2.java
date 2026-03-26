package exercise2;

public class bankAccount2 {
    String accountHolder;
    double balance;

    public bankAccount2(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public bankAccount2() {
        this.accountHolder = "Unknown";
        this.balance = 0;
    }

    public void deposit(double amount) {
        double initialBalance = balance;
        System.out.println("\n Hello, " + accountHolder + ", your initial balance is: " + balance);
        System.out.println(" You have deposited: " + amount);
        balance += amount;
    }

    public void withdraw(double amount, String reason) {
        if (amount > balance) {
            System.out.println("You don't have enough balance to withdraw this amount!");
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
