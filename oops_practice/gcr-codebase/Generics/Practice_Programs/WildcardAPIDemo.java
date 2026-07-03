import java.util.ArrayList;
import java.util.List;

public class WildcardAPIDemo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Rishav");
        names.add("Aman");
        names.add("Rahul");

        display(names);
    }

    public static void display(List<String> list) {

        for (String name : list) {
            System.out.println(name);
        }
    }
}