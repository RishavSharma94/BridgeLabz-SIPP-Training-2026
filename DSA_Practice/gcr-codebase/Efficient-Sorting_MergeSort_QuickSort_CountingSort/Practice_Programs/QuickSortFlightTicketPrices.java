public class QuickSortFlightTicketPrices {

    public static void main(String[] args) {

        int[] prices = {4500, 2200, 3800, 1800, 5200};

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Flight Ticket Prices:");

        for (int price : prices) {
            System.out.print(price + " ");
        }
    }

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
}