package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game score app!\n");
        System.out.print("Please enter a game score (Team1:Team2|Team1Score:Team2Score): ");
        String gameScore = sc.nextLine();

        String[] gameScoreSplit = gameScore.split(Pattern.quote("|"));
        // gameScoreSplit[0] <- team names

        String[] teams = gameScoreSplit[0].split(Pattern.quote(":"));
        String[] scores = gameScoreSplit[1].split(Pattern.quote(":"));
        //Home:Visitor|21:9
        String team1 = teams[0];
        String team2 = teams[1];
        int score1 = Integer.parseInt(scores[0]);
        int score2 = Integer.parseInt(scores[1]);
        String winner = "none";

        if (score1 > score2) {
            winner = team1;
        } else if (score2 > score1) {
            winner = team2;
        } else {
            winner = "tie";
        }

        System.out.println("Winner: " + winner);
    }
}
