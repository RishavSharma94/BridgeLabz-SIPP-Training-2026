import java.util.ArrayList;
import java.util.List;

public class ReadOnlyEmployeeList {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Rishav"));
        employees.add(new Employee(102, "Aman"));
        employees.add(new Employee(103, "Rahul"));

        displayEmployees(employees);
    }

    public static void displayEmployees(List<? extends Employee> list) {

        System.out.println("Employee Details:");

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}

class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name;
    }
}