package exercise3;

public abstract class Employee {
    String empName;
    int empSalary;

    public Employee(String empName, int empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public int calculatePay() {
        return empSalary;
    }
}





