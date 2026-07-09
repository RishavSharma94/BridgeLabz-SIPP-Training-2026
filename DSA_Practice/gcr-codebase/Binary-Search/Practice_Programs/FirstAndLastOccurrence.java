public class FirstAndLastOccurrence {

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 4, 6, 8, 10};

        int target = 4;

        System.out.println("First Occurrence: " + firstOccurrence(arr, target));
        System.out.println("Last Occurrence: " + lastOccurrence(arr, target));
    }

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
}