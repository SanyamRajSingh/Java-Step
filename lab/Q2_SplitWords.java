package week1.lab;

import java.util.Scanner;

public class Q2_SplitWords {
    public static String[] manualSplit(String text) {
        return text.trim().split(" +");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String s = sc.nextLine();
        String[] words1 = manualSplit(s);
        String[] words2 = s.split(" ");
        System.out.println("Manual split:");

        for(String w : words1) {
            System.out.println(w);
        }

        System.out.println("Built-in split:");

        for(String w : words2) {
            System.out.println(w);
        }

    }
}