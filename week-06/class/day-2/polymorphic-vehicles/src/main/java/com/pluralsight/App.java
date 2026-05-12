package com.pluralsight;

import com.pluralsight.ui.HomeMenu;

/**
 * Main entry point for the VIS application.
 * This application allows users to view information about different types of vehicles
 * including Cars, Mopeds, Semi Trucks, and Hovercrafts.
 */
public class App {
    /**
     * Starts the VIS by launching the main menu.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n--- Vehicle Information System (VIS) ---");
        HomeMenu.run();
    }
}