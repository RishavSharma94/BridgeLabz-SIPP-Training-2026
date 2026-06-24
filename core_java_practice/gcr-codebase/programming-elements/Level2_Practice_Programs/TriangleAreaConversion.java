import java.util.Scanner;

public class TriangleAreaConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base = sc.nextDouble();
        double height = sc.nextDouble();

        double areaCm = 0.5 * base * height;

        double baseInch = base / 2.54;
        double heightInch = height / 2.54;
        double areaInch = 0.5 * baseInch * heightInch;

        System.out.println("The Area of the triangle in sq in is " + areaInch +
                " and sq cm is " + areaCm);
    }
}