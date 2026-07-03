import java.util.Arrays;
import java.util.List;

public class GenericStreamProcessing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        System.out.println("Even Numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Squares:");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        System.out.println();

        int max = numbers.stream()
                .max(Integer::compare)
                .get();

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println("Maximum = " + max);
        System.out.println("Average = " + average);
    }
}