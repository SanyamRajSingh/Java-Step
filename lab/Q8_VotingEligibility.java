package week1.lab;

import java.util.Scanner;

public class Q8_VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter ages of 10 students:");

        for(int i = 0; i < 10; ++i) {
            ages[i] = sc.nextInt();
        }

        for(int i = 0; i < 10; ++i) {
            System.out.println("Student " + (i + 1) + ": " + ages[i] + (ages[i] >= 18 ? " → Can Vote" : " → Cannot Vote"));
        }

    }
}
