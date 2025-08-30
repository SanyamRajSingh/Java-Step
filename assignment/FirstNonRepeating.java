package week1.assignment;

import java.io.PrintStream;
import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        int[] freq = new int[256];

        for(int i = 0; i < text.length(); ++i) {
            ++freq[text.charAt(i)];
        }

        for(int i = 0; i < text.length(); ++i) {
            if (freq[text.charAt(i)] == 1) {
                PrintStream var10000 = System.out;
                char var10001 = text.charAt(i);
                var10000.println("First non-repeating: " + var10001);
                sc.close();
                return;
            }
        }

        System.out.println("No unique character found.");
        sc.close();
    }
}