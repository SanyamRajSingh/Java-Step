package week2.practice_problems;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        System.out.println("Trimmed: " + trimmed);

        String replacedSpaces = trimmed.replace(' ', '_');
        System.out.println("Spaces replaced with _: " + replacedSpaces);

        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("Digits removed: " + noDigits);

        String[] words = trimmed.split("\\s+");
        System.out.print("Split words: ");
        for (String w : words) System.out.print(w + " ");
        System.out.println();

        String joined = String.join(" | ", words);
        System.out.println("Joined with ' | ': " + joined);

        System.out.println("Without Punctuation: " + removePunctuation(trimmed));
        System.out.println("Capitalized Words: " + capitalizeWords(trimmed));
        System.out.println("Reversed Word Order: " + reverseWordOrder(trimmed));

        countWordFrequency(trimmed);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        java.util.Map<String, Integer> freq = new java.util.HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word Frequency:");
        for (var entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
