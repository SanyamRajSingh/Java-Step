package week2.assignment;

import java.util.Random;
import java.util.Scanner;

public class PasswordAnalyzerGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password to analyze: ");
        String password = sc.nextLine();

        int upper = countUpper(password);
        int lower = countLower(password);
        int digits = countDigits(password);
        int special = countSpecial(password);

        int score = calculateScore(password.length(), upper, lower, digits, special);
        String strength = getStrength(score);

        System.out.printf("Password: %s\nLength: %d\nUppercase: %d\nLowercase: %d\nDigits: %d\nSpecial: %d\nScore: %d\nStrength: %s\n",
                password, password.length(), upper, lower, digits, special, score, strength);

        System.out.print("\nEnter length for new strong password: ");
        int length = sc.nextInt();
        System.out.println("Generated strong password: " + generateStrongPassword(length));
        sc.close();
    }

    public static int countUpper(String text) {
        int count = 0;
        for (char c : text.toCharArray()) if (c >= 'A' && c <= 'Z') count++;
        return count;
    }

    public static int countLower(String text) {
        int count = 0;
        for (char c : text.toCharArray()) if (c >= 'a' && c <= 'z') count++;
        return count;
    }

    public static int countDigits(String text) {
        int count = 0;
        for (char c : text.toCharArray()) if (c >= '0' && c <= '9') count++;
        return count;
    }

    public static int countSpecial(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (!(Character.isLetterOrDigit(c))) count++;
        }
        return count;
    }

    public static int calculateScore(int length, int upper, int lower, int digits, int special) {
        int score = 0;
        if (length > 8) score += 2 * (length - 8);
        if (upper > 0) score += 10;
        if (lower > 0) score += 10;
        if (digits > 0) score += 10;
        if (special > 0) score += 10;
        return score;
    }

    public static String getStrength(int score) {
        if (score > 50) return "Strong";
        else if (score > 20) return "Medium";
        else return "Weak";
    }

    public static String generateStrongPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!@#$%&*";

        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        // Ensure at least one char from each category
        sb.append(upper.charAt(rnd.nextInt(upper.length())));
        sb.append(lower.charAt(rnd.nextInt(lower.length())));
        sb.append(digits.charAt(rnd.nextInt(digits.length())));
        sb.append(specials.charAt(rnd.nextInt(specials.length())));

        String all = upper + lower + digits + specials;

        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(rnd.nextInt(all.length())));
        }

        // Simple shuffle
        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(arr.length);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }
}
