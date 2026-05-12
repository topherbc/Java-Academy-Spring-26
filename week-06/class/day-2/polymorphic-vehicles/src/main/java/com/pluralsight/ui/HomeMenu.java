package com.pluralsight.ui;

import com.pluralsight.constants.*;

/**
 * Main menu controller for the VIS application.
 * Handles the display of menu options and processes user selections.
 */
public class HomeMenu {

    /**
     * Runs the main menu loop for the VIS application.
     * Continuously displays the home screen and processes user input until exit.
     */
    public static void run() {
        do {
            homeScreen();
            userOptions();
        } while (true);
    }

    /**
     * Displays the home screen menu with available vehicle options.
     */
    public static void homeScreen() {
        System.out.println("\nWhich vehicle would you like to see information about?");

        final String menuFormat = "\t%s%d. %s%s%n";

        System.out.printf(menuFormat, ConsoleColors.RED, MenuOption.CAR, VehicleType.CAR, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.YELLOW, MenuOption.MOPED, VehicleType.MOPED, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE, MenuOption.SEMI_TRUCK, VehicleType.SEMI_TRUCK, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.PURPLE, MenuOption.HOVERCRAFT, VehicleType.HOVERCRAFT, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.CYAN, MenuOption.DISPLAY_ALL, "Display All", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BOLD, MenuOption.SEARCH, "Search Vehicles", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.CYAN_BOLD, MenuOption.ADD_VEHICLE, "Add Vehicle", ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.GREEN, MenuOption.EXIT, "Exit", ConsoleColors.RESET);
    }

    /**
     * Processes user menu selection and displays the corresponding vehicle information.
     * Validates input and displays error message for invalid choices.
     */
    public static void userOptions() {
        int choice = ConsoleUtil.getUserIntInput("Enter a number option: ");

        ConsoleUtil.clearScreen();
        System.out.println("print user choice: " + choice);
        switch (choice) {
            case MenuOption.CAR -> VehicleDisplay.displayRandomByType(VehicleType.CAR);
            case MenuOption.MOPED -> VehicleDisplay.displayRandomByType(VehicleType.MOPED);
            case MenuOption.SEMI_TRUCK -> VehicleDisplay.displayRandomByType(VehicleType.SEMI_TRUCK);
            case MenuOption.HOVERCRAFT -> VehicleDisplay.displayRandomByType(VehicleType.HOVERCRAFT);
            case MenuOption.DISPLAY_ALL -> VehicleDisplay.displayAll();
            case MenuOption.SEARCH -> SearchMenu.run();
            case MenuOption.ADD_VEHICLE -> AddMenu.run();
            case MenuOption.EXIT -> ConsoleUtil.exit();
            default -> System.out.printf("Invalid choice. Please enter a number between %d and %d.%n", MenuOption.MIN_OPTION, MenuOption.MAX_OPTION);
        }

        if (choice != MenuOption.SEARCH && choice != MenuOption.EXIT && choice != MenuOption.ADD_VEHICLE) {
            ConsoleUtil.waitAndContinue();
        }
    }
}