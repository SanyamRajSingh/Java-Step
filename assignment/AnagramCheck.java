package week1.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First text: ");
        String str1 = sc.nextLine();
        System.out.print("Second text: ");
        String str2 = sc.nextLine();
        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram");
        } else {
            char[] a1 = str1.toLowerCase().toCharArray();
            char[] a2 = str2.toLowerCase().toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);
            System.out.println(Arrays.equals(a1, a2) ? "Anagram" : "Not an anagram");
        }

        sc.close();
    }
}