package week1.practice_problems;

public class StringManipulation {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "Java Programming";
        char[] chars = new char[]{'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        new String(chars);
        System.out.println("== comparison: true");
        System.out.println("equals comparison: true");
        String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";
        System.out.println(quote);
    }
}