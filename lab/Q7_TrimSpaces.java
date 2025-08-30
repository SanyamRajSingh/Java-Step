package week1.lab;

import java.util.Scanner;

public class Q7_TrimSpaces {
    public static String manualTrim(String s) {
        int start = 0;

        int end;
        for(end = s.length() - 1; start <= end && s.charAt(start) == ' '; ++start) {
        }

        while(end >= start && s.charAt(end) == ' ') {
            --end;
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String s = sc.nextLine();
        System.out.println("Manual trim: [" + manualTrim(s) + "]");
        System.out.println("Built-in trim: [" + s.trim() + "]");
    }
}