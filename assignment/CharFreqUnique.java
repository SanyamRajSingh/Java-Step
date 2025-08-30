package week1.assignment;

import java.util.Scanner;

public class CharFreqUnique {
    public static String getUniqueChars(String text) {
        String result = "";

        for(int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String unique = getUniqueChars(text);
        System.out.println("Character frequencies:");

        for(int i = 0; i < unique.length(); ++i) {
            char ch = unique.charAt(i);
            int count = 0;

            for(int j = 0; j < text.length(); ++j) {
                if (text.charAt(j) == ch) {
                    ++count;
                }
            }

            System.out.println(ch + " : " + count);
        }

        sc.close();
    }
}