package week1.assignment;

import java.util.Scanner;

public class BMICalculator {
    public static double calcBMI(double weight, double heightCm) {
        double heightM = heightCm / (double)100.0F;
        return weight / (heightM * heightM);
    }

    public static String getStatus(double bmi) {
        if (bmi < (double)18.5F) {
            return "Underweight";
        } else if (bmi < (double)25.0F) {
            return "Normal";
        } else {
            return bmi < (double)30.0F ? "Overweight" : "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for(int i = 0; i < 10; ++i) {
            System.out.print("Weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Height (cm) of person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        System.out.println("\nHeight\tWeight\tBMI\tStatus");

        for(int i = 0; i < 10; ++i) {
            double bmi = calcBMI(data[i][0], data[i][1]);
            System.out.printf("%.1f\t%.1f\t%.2f\t%s\n", data[i][1], data[i][0], bmi, getStatus(bmi));
        }

        sc.close();
    }
}