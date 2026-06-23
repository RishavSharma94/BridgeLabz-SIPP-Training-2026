abstract class Shape {

    public abstract double area();
    public abstract double perimeter();
}

// Circle with immutable radius
class Circle extends Shape {

    private final double radius; // immutable

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {

    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double perimeter() {
        return a + b + c;
    }
}

public class ScenarioBasedQ_ShapeHierarchy {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4, 5);

        System.out.println("---- Shape Report ----");

        for (int i = 0; i < shapes.length; i++) {

            System.out.println("Shape " + (i + 1));
            System.out.println("Area: " + shapes[i].area());
            System.out.println("Perimeter: " + shapes[i].perimeter());
            System.out.println();
        }
    }
}