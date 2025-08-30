package week2.lab;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Original ASCII:");
        printAscii(text);

        System.out.println("Encrypted ASCII:");
        printAscii(encrypted);

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
        System.out.println("Decryption matches original? " + decrypted.equals(text));

        sc.close();
    }

    public static String encrypt(String text, int shift) {
        shift %= 26;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(shiftChar(c, shift));
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    private static char shiftChar(char c, int shift) {
        if (c >= 'A' && c <= 'Z') return (char) ('A' + (c - 'A' + shift + 26) % 26);
        if (c >= 'a' && c <= 'z') return (char) ('a' + (c - 'a' + shift + 26) % 26);
        return c;
    }

    public static void printAscii(String text) {
        for (char c : text.toCharArray()) System.out.print(c + "(" + (int)c + ") ");
        System.out.println();
    }
}
