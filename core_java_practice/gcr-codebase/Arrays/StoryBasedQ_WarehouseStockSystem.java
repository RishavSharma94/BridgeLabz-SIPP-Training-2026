import java.util.Scanner;

public class StoryBasedQ_WarehouseStockSystem {

    // Find max
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // Find min
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    // Find total
    public static int findTotal(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    // Detect duplicates
    public static void findDuplicates(int[] arr) {
        System.out.print("Duplicate items: ");
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (isDuplicate && !alreadyPrinted) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }

        if (!found) System.out.print("None");
        System.out.println();
    }

    // Rotate array
    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int last = arr[n - 1];

            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[0] = last;
        }
    }

    // Transpose matrix
    public static void transposeMatrix(int[][] matrix, int rows, int cols) {
        System.out.println("\nTransposed Shelf Grid:");

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📦 Warehouse Stock System 📦");

        int[] stock = new int[10];

        System.out.println("Enter stock of 10 items:");
        for (int i = 0; i < stock.length; i++) {
            stock[i] = sc.nextInt();
        }

        System.out.println("\nMax stock: " + findMax(stock));
        System.out.println("Min stock: " + findMin(stock));
        System.out.println("Total stock: " + findTotal(stock));

        findDuplicates(stock);

        System.out.print("\nEnter k for rotation: ");
        int k = sc.nextInt();

        rotateArray(stock, k);

        System.out.print("Rotated stock: ");
        for (int i : stock) {
            System.out.print(i + " ");
        }

        System.out.print("\n\nEnter rows: ");
        int r = sc.nextInt();

        System.out.print("Enter cols: ");
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter shelf grid:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        transposeMatrix(matrix, r, c);

        sc.close();
    }
}