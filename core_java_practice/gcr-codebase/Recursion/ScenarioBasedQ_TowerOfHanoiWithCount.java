import java.util.*;

public class ScenarioBasedQ_TowerOfHanoiWithCount {

    static int moveCount = 0;

    // 1. Tower of Hanoi with count
    public static void towerOfHanoi(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            moveCount++;
            return;
        }

        towerOfHanoi(n - 1, source, destination, helper);

        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moveCount++;

        towerOfHanoi(n - 1, helper, source, destination);
    }

    // 2. Binary Search (Recursive)
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        else if (target < arr[mid])
            return binarySearch(arr, left, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, right, target);
    }

    // 3. Sum of Digits (Recursive)
    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    // 4. Reverse String (Recursive)
    public static String reverseString(String str) {
        if (str.isEmpty()) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // 5. Check Balanced Parentheses (Without Stack)
    public static boolean isBalanced(String str, int index, int count) {
        if (count < 0) return false; // more ')' than '('

        if (index == str.length())
            return count == 0;

        char ch = str.charAt(index);

        if (ch == '(')
            return isBalanced(str, index + 1, count + 1);
        else if (ch == ')')
            return isBalanced(str, index + 1, count - 1);
        else
            return isBalanced(str, index + 1, count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- Tower of Hanoi --------
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        towerOfHanoi(n, 'A', 'B', 'C');
        System.out.println("Total Moves = " + moveCount);

        // -------- Binary Search --------
        int[] prices = {10, 20, 30, 40, 50, 60};

        System.out.print("Enter price to search: ");
        int target = sc.nextInt();

        int index = binarySearch(prices, 0, prices.length - 1, target);

        if (index != -1)
            System.out.println("Found at index: " + index);
        else
            System.out.println("Not Found");

        // -------- Sum of Digits --------
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Sum of digits: " + sumOfDigits(num));

        // -------- Reverse String --------
        sc.nextLine(); // clear buffer
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        System.out.println("Reversed: " + reverseString(str));

        // -------- Balanced Parentheses --------
        System.out.print("Enter parentheses string: ");
        String p = sc.nextLine();

        boolean result = isBalanced(p, 0, 0);
        System.out.println("Balanced: " + result);

        sc.close();
    }
}