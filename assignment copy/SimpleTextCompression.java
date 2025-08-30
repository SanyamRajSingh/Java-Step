package week2.assignment;

import java.util.Scanner;

public class SimpleTextCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();

        char[] chars = new char[256];
        int[] freq = new int[256];

        countFrequency(text, chars, freq);
        System.out.println("Character Frequency:");
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] > 0) System.out.println(chars[i] + ": " + freq[i]);
        }

        // Very simple compression: assign code '0', '1', ...
        String[] codes = new String[256];
        int code = 0;
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] > 0) codes[i] = Integer.toString(code++);
        }

        String compressed = compressText(text, codes);
        String decompressed = decompressText(compressed, codes, chars);

        System.out.println("Original Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);
        System.out.println("Decompression valid? " + text.equals(decompressed));
        sc.close();
    }

    public static void countFrequency(String text, char[] chars, int[] freq) {
        int uniqueCount = 0;
        for (char c : text.toCharArray()) {
            if (freq[c] == 0) {
                chars[uniqueCount++] = c;
            }
            freq[c]++;
        }
    }

    public static String compressText(String text, String[] codes) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(codes[c]).append(" ");
        return sb.toString().trim();
    }

    public static String decompressText(String compressed, String[] codes, char[] chars) {
        String[] parts = compressed.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            for (int i = 0; i < codes.length; i++) {
                if (p.equals(codes[i])) {
                    sb.append((char) i);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
