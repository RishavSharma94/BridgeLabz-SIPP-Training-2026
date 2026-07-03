import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScenarioBasedQ_GenericRepositorySystem {

    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Rishav", 101);
        System.out.println("Pair: " + pair.getFirst() + " " + pair.getSecond());

        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nStack Elements:");
        stack.display();

        System.out.println("\nPopped Element: " + stack.pop());

        Integer[] numbers = {25, 10, 80, 45, 60};

        System.out.println("\nMaximum = " + findMax(numbers));

        Repository<Student> studentRepository = new Repository<>();

        studentRepository.add(new Student(101, "Rishav"));
        studentRepository.add(new Student(102, "Aman"));

        System.out.println("\nRepository Data:");
        studentRepository.display();

        System.out.println("\nWildcard Print:");

        List<String> names = new ArrayList<>();
        names.add("Rahul");
        names.add("Kunal");
        names.add("Aman");

        printList(names);
    }

    public static <T extends Comparable<T>> T findMax(T[] arr) {

        T max = arr[0];

        for (T value : arr) {

            if (value.compareTo(max) > 0) {
                max = value;
            }
        }

        return max;
    }

    public static void printList(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

class Pair<T, U> {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class GenericStack<T> {

    private Stack<T> stack = new Stack<>();

    public void push(T value) {
        stack.push(value);
    }

    public T pop() {
        return stack.pop();
    }

    public void display() {

        for (T value : stack) {
            System.out.println(value);
        }
    }
}

class Repository<T> {

    private ArrayList<T> list = new ArrayList<>();

    public void add(T obj) {
        list.add(obj);
    }

    public void display() {

        for (T obj : list) {
            System.out.println(obj);
        }
    }
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