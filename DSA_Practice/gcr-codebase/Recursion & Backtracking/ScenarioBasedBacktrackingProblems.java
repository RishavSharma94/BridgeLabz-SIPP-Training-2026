import java.util.*;

public class ScenarioBasedBacktrackingProblems {

    static int N = 4;

    public static void main(String[] args) {

        System.out.println("N-Queens Solutions:");
        solveNQueens();

        System.out.println("\nPermutations:");
        permutations("ABC", "");

        System.out.println("\nSubsets:");
        int[] items = {1, 2, 3};
        subsets(items, 0, new ArrayList<>());

        System.out.println("\nCombinations with Target Sum:");
        int[] cost = {2, 3, 6, 7};
        combinationSum(cost, 7, 0, new ArrayList<>());
    }

    static void solveNQueens() {
        int[][] board = new int[N][N];
        placeQueen(board, 0);
    }

    static boolean placeQueen(int[][] board, int row) {
        if (row == N) {
            printBoard(board);
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                placeQueen(board, row + 1);
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
        System.out.println();
    }

    static void permutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            permutations(left + right, ans + ch);
        }
    }

    static void subsets(int[] arr, int index, List<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subsets(arr, index + 1, list);

        list.remove(list.size() - 1);
        subsets(arr, index + 1, list);
    }

    static void combinationSum(int[] arr, int target, int index, List<Integer> list) {
        if (target == 0) {
            System.out.println(list);
            return;
        }

        if (target < 0 || index == arr.length)
            return;

        list.add(arr[index]);
        combinationSum(arr, target - arr[index], index, list);

        list.remove(list.size() - 1);
        combinationSum(arr, target, index + 1, list);
    }
}