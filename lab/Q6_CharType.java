package week1.lab;

import java.util.Scanner;

public class Q6_CharType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        for(char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiouAEIOU".indexOf(ch) != -1) {
                    System.out.println(ch + " → Vowel");
                } else {
                    System.out.println(ch + " → Consonant");
                }
            } else {
                System.out.println(ch + " → Not a letter");
            }
        }

    }
}