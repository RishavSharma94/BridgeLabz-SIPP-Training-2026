import java.util.*;

public class ConflictFreeSensorPlacement {

    static int N = 4;

    public static void main(String[] args) {
        int[] sensorCol = new int[N];
        place(0, sensorCol);
    }

    static void place(int row, int[] sensorCol) {

        if (row == N) {
            print(sensorCol);
            return;
        }

        for (int col = 0; col < N; col++) {

            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;
                place(row + 1, sensorCol);
            }
        }
    }

    static boolean isSafe(int row, int col, int[] sensorCol) {

        for (int i = 0; i < row; i++) {

            if (sensorCol[i] == col)
                return false;

            if (Math.abs(sensorCol[i] - col) == Math.abs(i - row))
                return false;
        }

        return true;
    }

    static void print(int[] sensorCol) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (sensorCol[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }

        System.out.println();
    }
}