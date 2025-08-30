package week2.lab;

import java.util.ArrayList;
import java.util.Scanner;

public class SubstringReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Substring to find: ");
        String toFind = scanner.nextLine();
        System.out.print("Substring to replace: ");
        String toReplace = scanner.nextLine();

        ArrayList<Integer> positions = findAllPositions(text, toFind);
        String replaced = replaceSubstring(text, toFind, toReplace, positions);

        System.out.println("Manual replace result: " + replaced);
        System.out.println("Built-in replace result: " + text.replace(toFind, toReplace));
        System.out.println("Are they equal? " + replaced.equals(text.replace(toFind, toReplace)));
        scanner.close();
    }

    // Find all start indexes of substring in text
    public static ArrayList<Integer> findAllPositions(String text, String sub) {
        ArrayList<Integer> positions = new ArrayList<>();
        int index = text.indexOf(sub);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(sub, index + sub.length());
        }
        return positions;
    }

    // Replace substrings manually building new string
    public static String replaceSubstring(String text, String find, String replace, ArrayList<Integer> positions) {
        StringBuilder result = new StringBuilder();
        int textIndex = 0, posIndex = 0;

        while (textIndex < text.length()) {
            if (posIndex < positions.size() && textIndex == positions.get(posIndex)) {
                result.append(replace);
                textIndex += find.length();
                posIndex++;
            } else {
                result.append(text.charAt(textIndex));
                textIndex++;
            }
        }
        return result.toString();
    }
}
