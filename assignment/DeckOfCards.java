package week1.assignment;

import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {
    public static String[] initializeDeck() {
        String[] suits = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for(String suit : suits) {
            for(String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();

        for(int i = 0; i < deck.length; ++i) {
            int r = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Number of players: ");
        int players = sc.nextInt();
        System.out.print("Cards per player: ");
        int cards = sc.nextInt();
        if (players * cards > deck.length) {
            System.out.println("Not enough cards!");
        } else {
            for(int p = 0; p < players; ++p) {
                System.out.println("Player " + (p + 1) + ":");

                for(int c = 0; c < cards; ++c) {
                    System.out.println(deck[p * cards + c]);
                }

                System.out.println();
            }
        }

        sc.close();
    }
}