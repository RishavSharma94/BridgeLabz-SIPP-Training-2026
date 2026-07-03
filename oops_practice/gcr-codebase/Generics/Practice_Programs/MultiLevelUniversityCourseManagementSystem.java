import java.util.ArrayList;
import java.util.List;

public class MultiLevelUniversityCourseManagementSystem {

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();
        exam.addCourse(new ExamCourse("Operating System"));

        Course<AssignmentCourse> assignment = new Course<>();
        assignment.addCourse(new AssignmentCourse("Java"));

        Course<ResearchCourse> research = new Course<>();
        research.addCourse(new ResearchCourse("Artificial Intelligence"));

        displayCourses(exam.getCourses());
        displayCourses(assignment.getCourses());
        displayCourses(research.getCourses());
    }

    public static void displayCourses(List<? extends CourseType> list) {

        for (CourseType course : list) {
            System.out.println(course);
        }

        System.out.println();
    }
}

abstract class CourseType {

    String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + courseName;
    }
}

class ExamCourse extends CourseType {

    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {

    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {

    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {

    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}