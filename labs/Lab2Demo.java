package week8.labs;

abstract class Shape {
    protected double area;
    protected double perimeter;

    public abstract void calculateArea();

    public abstract void calculatePerimeter();

    public void printMetrics() {
        System.out.printf("Area = %.2f, Perimeter = %.2f%n", area, perimeter);
    }
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

public class Lab2Demo {
    public static void main(String[] args) {
        Circle c = new Circle(5.0);
        c.draw();
        c.calculateArea();
        c.calculatePerimeter();
        c.printMetrics();
    }
}
