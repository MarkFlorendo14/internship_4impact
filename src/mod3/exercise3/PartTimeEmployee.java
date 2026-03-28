package exercise3;

public class PartTimeEmployee extends Employee {
    int hoursWorked;
    int hourlyRate;

    public PartTimeEmployee(String empName, int empSalary, int hoursWorked, int hourlyRate) {
        super(empName, empSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public int calculatePay(){
         empSalary = hoursWorked * hourlyRate;
         System.out.print("\nHello " + empName);
         System.out.print("\nYour Calculated Salary is: " + empSalary);
         return empSalary;
    }
}
