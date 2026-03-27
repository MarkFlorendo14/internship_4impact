package exercise4;

public class Invoice implements Payable {
    int amount;

    public Invoice(int amount){
        this.amount = amount;
    }

    @Override
    public double getPaymentAmount(){
        System.out.println("Invoice amount is: " + amount);
        return amount;
    }

}
