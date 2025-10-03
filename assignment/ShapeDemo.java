package week8.assignment;

abstract class Shape {
    protected final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("Shape: " + name);
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape c = new Circle(5.0);
        c.displayInfo();
        System.out.printf("Area = %.2f%n", c.area());
        System.out.printf("Perimeter = %.2f%n", c.perimeter());

        System.out.println();

        Shape r = new Rectangle(4.0, 6.0);
        r.displayInfo();
        System.out.printf("Area = %.2f%n", r.area());
        System.out.printf("Perimeter = %.2f%n", r.perimeter());
    }
}
