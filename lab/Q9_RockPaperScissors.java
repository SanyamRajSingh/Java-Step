package week1.lab;

import java.util.Random;
import java.util.Scanner;

public class Q9_RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] choices = new String[]{"rock", "paper", "scissors"};
        int userWins = 0;
        int compWins = 0;
        System.out.print("How many rounds? ");
        int rounds = sc.nextInt();

        for(int i = 1; i <= rounds; ++i) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.next().toLowerCase();
            String comp = choices[(new Random()).nextInt(3)];
            System.out.println("Computer: " + comp);
            if (user.equals(comp)) {
                System.out.println("Draw!");
            } else if ((!user.equals("rock") || !comp.equals("scissors")) && (!user.equals("scissors") || !comp.equals("paper")) && (!user.equals("paper") || !comp.equals("rock"))) {
                System.out.println("Computer wins!");
                ++compWins;
            } else {
                System.out.println("You win!");
                ++userWins;
            }
        }

        System.out.println("Final Score → You: " + userWins + ", Computer: " + compWins);
    }
}