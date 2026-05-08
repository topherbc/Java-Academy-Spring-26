package com.pluralsight;

import java.util.HashMap;
import java.util.Scanner;

public class MainApp {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to blackjack!");
        System.out.print("Enter player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter player 2 name: ");
        String player2Name = scanner.nextLine();

        Deck deck = new Deck();
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();
        HashMap<String, Integer> rounds = new HashMap<>();
        rounds.put(player1Name, 0);
        rounds.put(player2Name, 0);

        deck.shuffle();

        for(int i = 0; i < deck.getSize(); i++){
            System.out.println("---Round " + (i + 1) + "---");
            // deal 2 cards
            for(int j = 0; j < 2; j++) {
                player1Hand.deal(deck.deal());
                player2Hand.deal(deck.deal());
            }

            int player1HandValue = player1Hand.getValue();
            System.out.println(player1Name + " hand is worth " + player1HandValue);

            int player2HandValue = player2Hand.getValue();
            System.out.println(player2Name + " hand is worth " + player2HandValue);

            //get closest to 21
            //if we are over 21 we bust
            //whoever is closest to 21 or equal to 21, wins
            //if both players are at ior under 21, and have same score, tie

            if (player1HandValue > 21 && player2HandValue > 21) {
                System.out.println("ALL BUST");
            } else if (player1HandValue > 21 && player2HandValue <= 21) {
                rounds.put(player2Name, rounds.get(player2Name) + 1);
                System.out.println(player2Name + " Wins!");
            } else if (player1HandValue <= 21 && player2HandValue > 21) {
                rounds.put(player1Name, rounds.get(player1Name) + 1);
                System.out.println(player1Name + " Wins!");
            } else if (player1HandValue == player2HandValue) {
                rounds.put(player2Name, rounds.get(player2Name) + 1);
                rounds.put(player1Name, rounds.get(player1Name) + 1);
                System.out.println("DRAW!");
            } else if (player1HandValue > player2HandValue) {
                rounds.put(player1Name, rounds.get(player1Name) + 1);
                System.out.println(player1Name + " Wins!");
            } else if (player2HandValue > player1HandValue) {
                rounds.put(player2Name, rounds.get(player2Name) + 1);
                System.out.println(player2Name + " Wins!");
            }

            System.out.println("\n\n\n\n\n");

            player1Hand.clear();
            player2Hand.clear();
        }

        System.out.println(player1Name+ " wins: " + rounds.get(player1Name));
        System.out.println(player2Name+ " wins: " + rounds.get(player2Name));
    }
}