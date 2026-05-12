package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.SearchOption;

/**
 * Search menu controller for the VIS application.
 * Handles search menu display and search operations.
 */
public class SearchMenu {

    /**
     * Displays the search menu and processes user search requests.
     */
    public static void run() {
        ConsoleUtil.clearScreen();

        displaySearchOptions();
        handleSearchChoice();
    }

    /**
     * Displays available search options.
     */
    private static void displaySearchOptions() {
        System.out.println("\n--- Search Vehicles ---");

        final String menuFormat = "\t%s%d. %s%s%n";

        System.out.printf(menuFormat, ConsoleColors.CYAN, SearchOption.COLOR, "Search by Color", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.PURPLE, SearchOption.TYPE, "Search by Type", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE, SearchOption.MAKE, "Search by Make", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.YELLOW, SearchOption.PASSENGER_COUNT, "Search by Passenger Count", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.GREEN, SearchOption.BACK, "Back to Main Menu", ConsoleColors.RESET);
    }

    /**
     * Handles user's search choice and executes the corresponding search.
     */
    private static void handleSearchChoice() {
        System.out.print("\nEnter search option: ");
        int choice = ConsoleUtil.getUserChoice();

        ConsoleUtil.clearScreen();

        switch (choice) {
            case SearchOption.COLOR -> searchByColor();
            case SearchOption.TYPE -> searchByType();
            case SearchOption.MAKE -> searchByMake();
            case SearchOption.PASSENGER_COUNT -> searchByPassengerCount();
            case SearchOption.BACK -> {} // Return to main menu
            default -> System.out.printf("Invalid choice. Please enter a number between %d and %d.%n", SearchOption.MIN_OPTION, SearchOption.MAX_OPTION);
        }

        if (choice != SearchOption.BACK) {
            ConsoleUtil.waitAndContinue();
        }
    }

    /**
     * Prompts user for color and displays matching vehicles.
     */
    private static void searchByColor() {
        VehicleDisplay.displayByColor(ConsoleUtil.getUserInput("Enter color to search: "));
    }

    /**
     * Prompts user for type and displays matching vehicles.
     */
    private static void searchByType() {
        VehicleDisplay.displayByType(ConsoleUtil.getUserInput("Enter type to search (Car/Moped/SemiTruck/Hovercraft): "));
    }

    /**
     * Prompts user for make and displays matching vehicles.
     */
    private static void searchByMake() {
        VehicleDisplay.displayByMake(ConsoleUtil.getUserInput("Enter make to search: "));
    }

    /**
     * Prompts user for passenger count and displays matching vehicles.
     */
    private static void searchByPassengerCount() {
        VehicleDisplay.displayByPassengerCount(ConsoleUtil.getUserIntInput("Enter minimum passenger count: "));
    }
}