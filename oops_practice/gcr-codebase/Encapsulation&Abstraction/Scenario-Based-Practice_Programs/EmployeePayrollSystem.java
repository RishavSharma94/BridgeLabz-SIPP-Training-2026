abstract class Employee {

    private int employeeId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {

    public static void main(String[] args) {

        FullTimeEmployee f = new FullTimeEmployee();
        f.setEmployeeId(1);
        f.setEmployeeName("Rishav");
        f.setMonthlySalary(50000);

        PartTimeEmployee p = new PartTimeEmployee();
        p.setEmployeeId(2);
        p.setEmployeeName("Rahul");
        p.setHoursWorked(20);
        p.setHourlyRate(500);

        f.displayEmployeeInfo();
        System.out.println("Salary: " + f.calculateSalary());

        System.out.println();

        p.displayEmployeeInfo();
        System.out.println("Salary: " + p.calculateSalary());
    }
}