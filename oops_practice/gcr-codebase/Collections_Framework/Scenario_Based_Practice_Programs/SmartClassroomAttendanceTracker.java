import java.util.ArrayList;
import java.util.HashMap;

public class SmartClassroomAttendanceTracker {

    public static void main(String[] args) {

        AttendanceManager manager = new AttendanceManager();

        manager.markAttendance("Java", "Rishav");
        manager.markAttendance("Java", "Aman");
        manager.markAttendance("Java", "Rishav");
        manager.markAttendance("Python", "Rahul");
        manager.markAttendance("Python", "Aman");
        manager.markAttendance("DSA", "Kunal");
        manager.markAttendance("DSA", "Rahul");

        System.out.println();

        manager.displayAttendance();
    }
}

class AttendanceManager {

    HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (!students.contains(student)) {

            students.add(student);
            System.out.println(student + " marked present in " + subject);

        } else {

            System.out.println(student + " is already present in " + subject);
        }
    }

    public void displayAttendance() {

        for (String subject : attendance.keySet()) {

            System.out.println("Subject: " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println("Total Students: " + students.size());
            System.out.println();
        }
    }
}