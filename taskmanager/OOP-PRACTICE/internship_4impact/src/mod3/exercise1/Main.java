package exercise1;

public class Main {
    public static void main (String[] args) {
        BankAccount1 acc1 = new BankAccount1("Mark Angelo Florendo", 1000.00);
        BankAccount1 acc2 = new BankAccount1("Kate Hermosa", 20000.00);

        acc1.deposit(500.00);
        acc2.accountStatus();
    }
}
