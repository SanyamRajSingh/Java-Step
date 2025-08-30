package week2.practice_problems;

import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;

            System.out.print("'" + ch + "' = ASCII: " + ascii + " - ");
            System.out.print(classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char toggled = toggleCase(ch);
                System.out.println("; Toggle case: '" + toggled + "' ASCII: " + (int) toggled);
            } else {
                System.out.println();
            }
        }

        System.out.println("ASCII Table from 32 to 126:");
        displayASCIITable(32, 126);

        System.out.print("Enter Caesar cipher shift value: ");
        int shift = scanner.nextInt();
        System.out.println("Ciphered text: " + caesarCipher(input, shift));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return Character.toLowerCase(ch);
        if (Character.isLowerCase(ch)) return Character.toUpperCase(ch);
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + shift + 26) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " = " + (char) i);
        }
    }
}
