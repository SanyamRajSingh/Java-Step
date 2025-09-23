package week6.assignments;

class BasicMath {
    public int calculate(int a, int b) {
        return a + b;
    }

    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}

class AdvancedMath extends BasicMath {
    public int calculate(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public double calculate(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();

        System.out.println("Sum of 2: " + math.calculate(3, 5));
        System.out.println("Sum of 3: " + math.calculate(3, 5, 7));
        System.out.println("Sum of 4: " + math.calculate(3, 5, 7, 2));
        System.out.println("Product of doubles: " + math.calculate(3.5, 2.0));
    }
}
