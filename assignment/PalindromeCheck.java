package week1.assignment;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        boolean isPalindrome = true;

        for(int i = 0; i < text.length() / 2; ++i) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not a palindrome");
        sc.close();
    }
}