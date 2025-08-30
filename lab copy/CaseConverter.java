package week2.lab;

import java.util.Scanner;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        System.out.println("Uppercase: " + toUpperCase(input));
        System.out.println("Lowercase: " + toLowerCase(input));
        System.out.println("Title Case: " + toTitleCase(input));
        sc.close();
    }

    public static String toUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toUpper(c));
        return sb.toString();
    }

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
    }

    public static String toLowerCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(toLower(c));
        return sb.toString();
    }

    public static char toLower(char c) {
        return (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
    }

    public static String toTitleCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                start = true;
            } else {
                sb.append(start ? toUpper(c) : toLower(c));
                start = false;
            }
        }
        return sb.toString();
    }
}
