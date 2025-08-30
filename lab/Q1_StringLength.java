package week1.lab;

import java.util.Scanner;

public class Q1_StringLength {
    public static int findLength(String s) {
        int count = 0;

        try {
            while(true) {
                s.charAt(count);
                ++count;
            }
        } catch (Exception var3) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.next();
        System.out.println("Length (manual): " + findLength(s));
        System.out.println("Length (built-in): " + s.length());
    }
}