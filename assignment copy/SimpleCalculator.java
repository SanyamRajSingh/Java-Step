package week2.assignment;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter simple expression (e.g. 2 + 3 * 4): ");
        String expr = sc.nextLine();

        if (isValidExpression(expr)) {
            double result = evaluateExpression(expr);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression.");
        }
        sc.close();
    }

    public static boolean isValidExpression(String expr) {
        for (char c : expr.toCharArray()) {
            if (!Character.isDigit(c) && "+-*/() ".indexOf(c) == -1) return false;
        }
        return true;
    }

    public static double evaluateExpression(String expr) {
        String[] tokens = expr.split(" ");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            double next = Double.parseDouble(tokens[i + 1]);
            switch (tokens[i]) {
                case "+" -> result += next;
                case "-" -> result -= next;
                case "*" -> result *= next;
                case "/" -> result /= next;
            }
        }
        return result;
    }
}
