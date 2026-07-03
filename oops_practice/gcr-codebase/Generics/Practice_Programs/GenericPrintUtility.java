public class GenericPrintUtility {

    public static void main(String[] args) {

        Integer[] numbers = {10,20,30};

        String[] names = {"Rishav","Aman","Rahul"};

        Double[] marks = {85.5,92.3,77.4};

        printArray(numbers);

        System.out.println();

        printArray(names);

        System.out.println();

        printArray(marks);
    }

    public static <T> void printArray(T[] array) {

        for (T element : array) {
            System.out.println(element);
        }
    }
}