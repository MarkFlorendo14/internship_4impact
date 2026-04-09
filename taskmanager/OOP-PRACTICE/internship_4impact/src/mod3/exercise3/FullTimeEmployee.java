package exercise3;

public class FullTimeEmployee extends Employee {
    int bonus;

    public FullTimeEmployee(String empName, int empSalary, int bonus){
        super(empName, empSalary);
        this.bonus = bonus;
    }

    @Override
    public int calculatePay(){
        int salary = empSalary + bonus;
        System.out.print("Hello " + empName);
        System.out.print("\nYour Calculated Salary is: " + salary);
        return salary;
    }

}
