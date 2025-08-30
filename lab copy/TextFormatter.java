package week2.lab;

import java.util.ArrayList;
import java.util.Scanner;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        String[] words = splitWords(text);

        System.out.println("\nLeft justified text:");
        ArrayList<String> lines = justifyText(words, width);
        printWithLineNumbers(lines);

        System.out.println("\nCenter aligned text:");
        printCentered(lines, width);

        sc.close();
    }

    public static String[] splitWords(String text) {
        ArrayList<String> wordsList = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) wordsList.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) wordsList.add(text.substring(start));
        return wordsList.toArray(new String[0]);
    }

    public static ArrayList<String> justifyText(String[] words, int width) {
        ArrayList<String> lines = new ArrayList<>();

        StringBuilder line = new StringBuilder();
        int lineLen = 0;

        for (String word : words) {
            if (lineLen + word.length() + (lineLen == 0 ? 0 : 1) > width) {
                lines.add(line.toString());
                line = new StringBuilder(word);
                lineLen = word.length();
            } else {
                if (lineLen != 0) line.append(" ");
                line.append(word);
                lineLen += word.length() + (lineLen == 0 ? 0 : 1);
            }
        }
        if (lineLen > 0) lines.add(line.toString());
        return lines;
    }

    public static void printWithLineNumbers(ArrayList<String> lines) {
        int count = 1;
        for (String line : lines) {
            System.out.printf("%2d: %s (Chars: %d)%n", count++, line, line.length());
        }
    }

    public static void printCentered(ArrayList<String> lines, int width) {
        for (String line : lines) {
            int padding = (width - line.length()) / 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < padding; i++) sb.append(" ");
            sb.append(line);
            System.out.println(sb);
        }
    }
}
