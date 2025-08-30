package week2.practice_problems;

public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";

        System.out.println("Original length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("Trimmed length: " + trimmed.length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        System.out.println("Substring \"Programming\": " + sampleText.substring(5, 16));
        System.out.println("Index of \"Fun\": " + sampleText.indexOf("Fun"));
        System.out.println("Contains \"Java\": " + sampleText.contains("Java"));
        System.out.println("Starts with \"Java\" after trimming: " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + trimmed.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());

        System.out.println("Vowel count: " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        System.out.print("Positions of '" + target + "': ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) System.out.print(i + " ");
        }
        System.out.println();
    }
}
