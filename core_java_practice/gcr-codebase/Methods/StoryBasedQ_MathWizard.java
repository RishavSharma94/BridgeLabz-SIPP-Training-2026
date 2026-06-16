import java.util.*;

public class MathWizard {

    // Instance variable (to demonstrate scope)
    int instanceVar = 100;

    // 1. Prime check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 2. Factorial (iteration)
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Overloaded factorial (double)
    public static double factorial(double n) {
        double fact = 1;
        for (int i = 1; i <= (int)n; i++) {
            fact *= i;
        }
        return fact;
    }

    // 3. Fibonacci
    public static void fibonacci(int n) {
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // 4. GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 5. LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // 6. Power
    public static int power(int base, int exp) {
        int result = 1;

        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // Method to demonstrate scope
    public void scopeDemo() {
        int localVar = 50; // local variable

        System.out.println("Local Variable: " + localVar);
        System.out.println("Instance Variable: " + instanceVar);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Is Prime: " + isPrime(n));

        System.out.println("Factorial (int): " + factorial(n));
        System.out.println("Factorial (double): " + factorial((double)n));

        fibonacci(n);

        System.out.print("Enter two numbers for GCD & LCM: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));

        System.out.print("Enter base and exponent: ");
        int base = sc.nextInt();
        int exp = sc.nextInt();

        System.out.println("Power: " + power(base, exp));

        // Scope demonstration
        MathWizard obj = new MathWizard();
        obj.scopeDemo();

        sc.close();
    }
}