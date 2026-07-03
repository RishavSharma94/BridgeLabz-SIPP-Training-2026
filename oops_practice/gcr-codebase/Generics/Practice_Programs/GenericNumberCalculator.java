public class GenericNumberCalculator {

    public static void main(String[] args) {

        Integer[] numbers = {10, 20, 30, 40};

        Double[] marks = {80.5, 90.0, 75.5};

        System.out.println("Integer Sum: " + calculateSum(numbers));
        System.out.println("Double Sum: " + calculateSum(marks));
    }

    public static <T extends Number> double calculateSum(T[] array) {

        double sum = 0;

        for (T value : array) {
            sum += value.doubleValue();
        }

        return sum;
    }
}