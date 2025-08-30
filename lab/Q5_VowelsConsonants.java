package week1.lab;

import java.util.Scanner;

public class Q5_VowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine().toLowerCase();
        int v = 0;
        int c = 0;

        for(char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                ++v;
            } else if (ch >= 'a' && ch <= 'z') {
                ++c;
            }
        }

        System.out.println("Vowels: " + v + " | Consonants: " + c);
    }
}