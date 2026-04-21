package com.pluralsight;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        String[] quotes = {
                "If you think you understand quantum mechanics, you don't. – Richard Feynman",
                "The Tao that can be told is not the eternal Tao. – Laozi",
                "Not only is the universe stranger than we think, it is stranger than we can think. – Heisenberg",
                "The religion of the future will be a cosmic religion. – Einstein",
                "Peace comes from within. Do not seek it without. – Buddha",
                "An equation means nothing to me unless it expresses a thought of God. – Ramanujan",
                "The atoms of our bodies are traceable to stars that exploded. – Neil deGrasse Tyson",
                "The most beautiful thing we can experience is the mysterious. – Einstein",
                "He who knows himself knows his Lord. – Ibn Arabi",
                "Before enlightenment, chop wood, carry water. After enlightenment, chop wood, carry water. – Zen proverb"
        };

        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        do {
            System.out.println("\nEnter a number 1-10 to see a quote:");

            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("\n" + quotes[input - 1]);

            } catch (NumberFormatException e) {
                System.out.println("That's not a number. Try again next round.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Number out of range. Pick between 1 and 10.");
            }

            System.out.println("\nWant to see another quote? (yes/no):");
            continueChoice = scanner.nextLine().trim().toLowerCase();

        } while (continueChoice.equals("yes"));

        System.out.println("Later.");
        scanner.close();
    }
}