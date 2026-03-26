package exercise2;

import exercise1.BankAccount1;

public class Main {
    public static void main (String[] args) {
        bankAccount2 acc1 = new bankAccount2("Mark Angelo", 10000.00);
        bankAccount2 acc2 = new bankAccount2();


        acc1.deposit(50);
        acc1.accountStatus();
        acc1.withdraw(5000.00, "For my medication");

        acc2.accountStatus();
    }
}
