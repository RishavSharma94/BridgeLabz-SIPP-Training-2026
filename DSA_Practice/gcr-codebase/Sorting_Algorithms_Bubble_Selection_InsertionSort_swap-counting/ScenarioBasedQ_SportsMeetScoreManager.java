import java.util.Arrays;

public class ScenarioBasedQ_SportsMeetScoreManager {

    public static void main(String[] args) {

        int[] scores = {
                85, 72, 91, 68, 77, 88, 95, 70, 83, 79,
                65, 90, 74, 81, 69, 92, 87, 76, 84, 71,
                66, 89, 73, 80, 67, 94, 82, 78, 75, 86,
                96, 64, 93, 63, 97, 62, 98, 61, 99, 60,
                100, 59, 58, 57, 56, 55, 54, 53, 52, 51
        };

        int[] bubbleArray = Arrays.copyOf(scores, scores.length);
        int[] insertionArray = Arrays.copyOf(scores, scores.length);

        bubbleSort(bubbleArray);

        System.out.println();

        insertionSort(insertionArray);

        System.out.println();

        System.out.println("Top 3 Medalists:");
        System.out.println("Gold   : " + bubbleArray[bubbleArray.length - 1]);
        System.out.println("Silver : " + bubbleArray[bubbleArray.length - 2]);
        System.out.println("Bronze : " + bubbleArray[bubbleArray.length - 3]);

        System.out.println();

        int[] trace = {64, 25, 12, 22, 11};

        traceBubbleSort(trace);
    }

    public static void bubbleSort(int[] arr) {

        int swaps = 0;
        boolean sorted = true;

        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                    sorted = false;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.println("Bubble Sort Completed");
        System.out.println("Total Swaps = " + swaps);

        if (sorted) {
            System.out.println("Best Case: Already Sorted");
        } else {
            System.out.println("Array was not initially sorted");
        }
    }

    public static void insertionSort(int[] arr) {

        int swaps = 0;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort Completed");
        System.out.println("Total Shifts = " + swaps);
    }

    public static void traceBubbleSort(int[] arr) {

        System.out.println("Bubble Sort Pass-by-Pass:");

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.print("Pass " + (i + 1) + ": ");

            for (int value : arr) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}