import java.util.Scanner;

public class EmployeeBonusZara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Employee " + (i+1) + " salary: ");
            salary[i] = sc.nextDouble();
            System.out.print("Employee " + (i+1) + " years: ");
            years[i] = sc.nextDouble();
        }
        
        double totalBonus = 0, totalOld = 0, totalNew = 0;
        
        for (int i = 0; i < 10; i++) {
            double rate = (years[i] > 5) ? 0.05 : 0.02;
            bonus[i] = salary[i] * rate;
            newSalary[i] = salary[i] + bonus[i];
            
            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += newSalary[i];
        }
        
        System.out.println("\nEmployee Summary:");
        System.out.println("Emp\tOld\tBonus\tNew");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\n", i+1, salary[i], bonus[i], newSalary[i]);
        }
        
        System.out.println("\nTotal old salary: " + totalOld);
        System.out.println("Total bonus: " + totalBonus);
        System.out.println("Total new salary: " + totalNew);
    }
}
