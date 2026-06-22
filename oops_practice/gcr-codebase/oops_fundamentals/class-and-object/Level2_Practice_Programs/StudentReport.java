class Student {

    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }

    void display() {
        System.out.println(name + " | Roll: " + rollNumber +
                " | Marks: " + marks +
                " | Grade: " + calculateGrade());
    }
}

public class StudentReport {

    public static void main(String[] args) {

        Student s1 = new Student("Rishav", 1, 85);
        s1.display();
    }
}