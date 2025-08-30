package week2.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleSpellChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        String[] dictionary = {"java", "program", "fun", "challenge", "code", "test", "example"};

        String[] words = splitSentenceToWords(sentence);
        System.out.printf("%-15s %-15s %-10s %-10s%n", "Word", "Suggestion", "Distance", "Status");

        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = calculateDistance(word, suggestion);
            String status = (distance <= 2) ? "Misspelled" : "Correct";
            if (distance > 2) suggestion = word;
            System.out.printf("%-15s %-15s %-10d %-10s%n", word, suggestion, distance, status);
        }

        sc.close();
    }

    // Split sentence without using split()
    public static String[] splitSentenceToWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || !Character.isLetter(text.charAt(i))) {
                if (start < i) words.add(text.substring(start, i).toLowerCase());
                start = i + 1;
            }
        }
        return words.toArray(new String[0]);
    }

    // Calculate simple string distance - char differences + length difference
    public static int calculateDistance(String w1, String w2) {
        int dist = Math.abs(w1.length() - w2.length());
        int minLen = Math.min(w1.length(), w2.length());
        for (int i = 0; i < minLen; i++) {
            if (w1.charAt(i) != w2.charAt(i)) dist++;
        }
        return dist;
    }

    // Find closest word in dictionary with min distance <= 2
    public static String findClosestWord(String word, String[] dictionary) {
        int minDist = Integer.MAX_VALUE;
        String closest = word;
        for (String dictWord : dictionary) {
            int dist = calculateDistance(word, dictWord);
            if (dist < minDist) {
                minDist = dist;
                closest = dictWord;
            }
        }
        return closest;
    }
}
