import java.util.*;

public class SumNaturalNumbers {

    // recursion
    public static int sumRec(int n) {
        if (n == 0) return 0;
        return n + sumRec(n - 1);
    }

    // formula
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int rec = sumRec(n);
        int formula = sumFormula(n);

        System.out.println("Recursion Sum = " + rec);
        System.out.println("Formula Sum = " + formula);

        if (rec == formula)
            System.out.println("Both results are SAME");
        else
            System.out.println("Results are DIFFERENT");
    }
}