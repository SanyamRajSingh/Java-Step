package week2.lab;

import java.util.Scanner;

public class StringPerformanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        System.out.println("String + operator time (ms): " + testStringConcat(n));
        System.out.println("StringBuilder append time (ms): " + testStringBuilder(n));
        System.out.println("StringBuffer append time (ms): " + testStringBuffer(n));

        sc.close();
    }

    public static long testStringConcat(int n) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) s += "a";
        return System.currentTimeMillis() - start;
    }

    public static long testStringBuilder(int n) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }

    public static long testStringBuffer(int n) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append("a");
        return System.currentTimeMillis() - start;
    }
}
