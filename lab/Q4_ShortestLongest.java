package week1.lab;

import java.util.Scanner;

public class Q4_ShortestLongest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String s = sc.nextLine();
        String[] words = s.trim().split(" +");
        String shortest = words[0];
        String longest = words[0];

        for(String w : words) {
            if (w.length() < shortest.length()) {
                shortest = w;
            }

            if (w.length() > longest.length()) {
                longest = w;
            }
        }

        System.out.println("Shortest: " + shortest);
        System.out.println("Longest: " + longest);
    }
}