package week9.labs;

interface MathOperation {
    int operate(int a, int b);
}

class Calculator {
    // Static nested class
    public static class Operation {
        public static int add(int a, int b) { return a + b; }
    }

    public void subtractionDemo() {
        // Local inner class
        class Subtract {
            int subtract(int a, int b) { return a - b; }
        }
        Subtract sub = new Subtract();
        System.out.println("Subtract: " + sub.subtract(10, 7));
    }

    public void multiplicationDemo() {
        MathOperation multiplication = new MathOperation() {
            public int operate(int a, int b) { return a * b; }
        };
        System.out.println("Multiply: " + multiplication.operate(3, 4));
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        System.out.println("Add: " + Calculator.Operation.add(4, 5));
        Calculator calc = new Calculator();
        calc.subtractionDemo();
        calc.multiplicationDemo();
    }
}
