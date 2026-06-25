public class ScenarioBasedQ_UniversitySystem {

    public static void main(String[] args) {

        GradStudent gradStudent = new GradStudent(
                "Rishav Sharma",
                101,
                8.9,
                "Artificial Intelligence in Education"
        );

        System.out.println(gradStudent);

        System.out.println("\nIS-A Relationship Check:");
        System.out.println("GradStudent IS-A Student: " + (gradStudent instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (gradStudent instanceof Person));
    }
}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person Name: " + name;
    }
}

class Student extends Person {

    private final int studentId;
    private double gpa;

    public Student(String name, int studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nStudent ID: " + studentId
                + "\nGPA: " + gpa;
    }
}

class GradStudent extends Student {

    private String thesis;

    public GradStudent(String name, int studentId, double gpa, String thesis) {
        super(name, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nThesis: " + thesis;
    }
}