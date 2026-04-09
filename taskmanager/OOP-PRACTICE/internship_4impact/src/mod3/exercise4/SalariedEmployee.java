package exercise4;

public class SalariedEmployee extends Person implements Payable {
    int salary;
    String empName;

    public SalariedEmployee(String empName, int salary){
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public double getPaymentAmount() {
        System.out.println("Hello, " + empName + " your computed salary is: " + salary);
        return salary;
    }

    @Override
    public void getDescription(String name) {
        System.out.print("This is employee: " + name);
    }
}
