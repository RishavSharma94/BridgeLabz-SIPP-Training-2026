import java.util.ArrayList;

public class GenericRepositoryDemo {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

        studentRepository.save(new Student(101, "Rishav"));
        studentRepository.save(new Student(102, "Aman"));

        System.out.println("Students:");
        studentRepository.display();

        System.out.println();

        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.save(new Employee(201, "Rahul"));
        employeeRepository.save(new Employee(202, "Kunal"));

        System.out.println("Employees:");
        employeeRepository.display();
    }
}

interface Repository<T> {

    void save(T obj);

    void display();
}

class Student {

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

class StudentRepository implements Repository<Student> {

    ArrayList<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public void display() {

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class EmployeeRepository implements Repository<Employee> {

    ArrayList<Employee> employees = new ArrayList<>();

    public void save(Employee employee) {
        employees.add(employee);
    }

    public void display() {

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}