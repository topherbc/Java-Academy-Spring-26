package com.pluralsight.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class for console operations in the VIS application.
 * Provides methods for user input, screen management, and program flow control.
 */
public class ConsoleUtil {
    private static final int CLEAR_SCREEN_LINES = 60;
    private static final int INVALID_INPUT = -1;
    private static final String RETURN_TO_MENU_MESSAGE = "\nPress Enter to return to menu";
    private static final String EXIT_MESSAGE = "Thank you for using the Vehicle Information System (VIS)!";
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Gets an integer choice from the user.
     * Handles invalid input by returning -1.
     *
     * @return the user's choice as an integer, or -1 if input is invalid
     */
    public static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return INVALID_INPUT;
        }
    }

    /**
     * Gets a string input from the user.
     *
     * @param prompt the prompt to display to the user
     * @return the user's input as a string
     */
    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Gets an integer input from the user with a prompt.
     *
     * @param prompt the prompt to display to the user
     * @return the user's input as an integer, or -1 if invalid
     */
    public static int getUserIntInput(String prompt) {
        System.out.print(prompt);
        return getUserChoice();
    }

    /**
     * Pauses execution and waits for the user to press Enter.
     */
    public static void waitForEnter() {
        System.out.println(RETURN_TO_MENU_MESSAGE);
        scanner.nextLine();
    }

    /**
     * Clears the console screen by printing empty lines.
     */
    public static void clearScreen() {
        for (int i = 0; i < CLEAR_SCREEN_LINES; i++) {
            System.out.println();
        }
    }

    /**
     * Waits for user to press Enter, then clears the screen.
     */
    public static void waitAndContinue() {
        waitForEnter();
        clearScreen();
    }

    /**
     * Displays exit message, closes the scanner, and terminates the program.
     */
    public static void exit() {
        System.out.println(EXIT_MESSAGE);
        scanner.close();
        System.exit(0);
    }
}