package exercise3;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee("Mark", 20000, 5000);
        Employee emp2 = new PartTimeEmployee("Kate", 0, 9, 600);

        emp1.calculatePay();
        emp2.calculatePay();
    }
}
