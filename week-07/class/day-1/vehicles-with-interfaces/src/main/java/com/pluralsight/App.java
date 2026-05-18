package com.pluralsight;

import com.pluralsight.ui.HomeMenu;

/**
 * Main entry point for the VIS application.
 * This application allows users to view information about different types of vehicles
 * including Cars, Mopeds, Semi Trucks, and Hovercrafts.
 */
public class App {
    private static final String WELCOME_MESSAGE = "--- Vehicle Information System (VIS) ---";

    /**
     * Starts the VIS by launching the main menu.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        displayWelcome();
        HomeMenu.run();
    }

    /**
     * Displays the welcome message for the application.
     */
    private static void displayWelcome() {
        System.out.println("\n" + WELCOME_MESSAGE);
    }
}