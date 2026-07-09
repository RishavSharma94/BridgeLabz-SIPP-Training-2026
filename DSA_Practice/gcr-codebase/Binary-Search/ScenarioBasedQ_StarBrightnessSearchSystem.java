public class ScenarioBasedQ_StarBrightnessSearchSystem {

    public static void main(String[] args) {

        // Sorted Brightness Values
        int[] brightness = {10, 15, 20, 20, 20, 25, 30, 35, 40, 45};

        int target = 20;

        System.out.println("Binary Search Index : "
                + binarySearch(brightness, target));

        System.out.println("First Occurrence : "
                + firstOccurrence(brightness, target));

        System.out.println("Last Occurrence : "
                + lastOccurrence(brightness, target));

        // Rotated Sorted Array
        int[] rotated = {30, 35, 40, 45, 10, 15, 20, 25};

        System.out.println("Target in Rotated Array : "
                + searchRotated(rotated, 20));

        System.out.println("Minimum Brightness : "
                + findMinimum(rotated));
    }

    // Binary Search
    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // First Occurrence
    static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Last Occurrence
    static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Search in Rotated Sorted Array
    static int searchRotated(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[left] <= arr[mid]) {

                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else {

                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    // Find Minimum in Rotated Sorted Array
    static int findMinimum(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return arr[left];
    }
}