import java.util.Random;

public class ScenarioBasedQ_LibrarySortingSystem {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {

            System.out.println("\nArray Size : " + size);

            int[] mergeArray = generateRandomYears(size);
            int[] quickArray = mergeArray.clone();
            int[] countingArray = generateRandomGenres(size);

            long start = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long end = System.nanoTime();
            System.out.println("Merge Sort Time : " + (end - start) + " ns");

            start = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort Time : " + (end - start) + " ns");

            start = System.nanoTime();
            countingSort(countingArray);
            end = System.nanoTime();
            System.out.println("Counting Sort Time : " + (end - start) + " ns");
        }
    }

    // Generate Random Publication Years
    static int[] generateRandomYears(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1950 + random.nextInt(76);
        }

        return arr;
    }

    // Generate Random Genre Codes (1-20)
    static int[] generateRandomGenres(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1 + random.nextInt(20);
        }

        return arr;
    }

    // Merge Sort
    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];

        for (int i = 0; i < n2; i++)
            rightArray[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        }

        while (i < n1)
            arr[k++] = leftArray[i++];

        while (j < n2)
            arr[k++] = rightArray[j++];
    }

    // Quick Sort (Lomuto Partition)
    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Counting Sort (Genre Codes 1-20)
    static void countingSort(int[] arr) {

        int[] count = new int[21];

        for (int value : arr)
            count[value]++;

        int index = 0;

        for (int i = 1; i <= 20; i++) {

            while (count[i] > 0) {

                arr[index++] = i;
                count[i]--;
            }
        }
    }
}