import java.util.ArrayList;
import java.util.List;

public class AvoidUsingRawTypes {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Rishav");
        names.add("Aman");
        names.add("Rahul");

        displayList(names);
    }

    public static void displayList(List<String> list) {

        System.out.println("Student Names:");

        for (String name : list) {
            System.out.println(name);
        }
    }
}