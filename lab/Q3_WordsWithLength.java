package week1.lab;

import java.util.Scanner;

public class Q3_WordsWithLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String s = sc.nextLine();
        String[] words = s.trim().split(" +");
        System.out.println("Word\tLength");

        for(String w : words) {
            System.out.println(w + "\t" + w.length());
        }

    }
}
