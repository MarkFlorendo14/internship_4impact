package exercise4;

public class Main {
    public static void main (String[] args){

        Payable[] payables = new Payable[5];
            payables[0] = new Invoice(50000);
            payables[1] = new SalariedEmployee("Mark Angelo", 20000);
            payables[2] = new Invoice(11000);
            payables[3] = new SalariedEmployee("Kate Hermosa", 100000);
            payables[4] = new Invoice(30000);

            for (Payable p : payables){
                p.getPaymentAmount();
            }
    }
}


