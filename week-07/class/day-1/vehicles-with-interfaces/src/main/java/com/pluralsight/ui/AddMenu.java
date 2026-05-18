package com.pluralsight.ui;

import com.pluralsight.constants.AddOption;
import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.VehicleType;
import com.pluralsight.data.Inventory;
import com.pluralsight.models.*;

/**
 * Add vehicle menu controller for the VIS application.
 * Handles adding new vehicles to the inventory.
 */
public class AddMenu {

    /**
     * Displays the add vehicle menu and processes user requests.
     */
    public static void run() {
        ConsoleUtil.clearScreen();

        displayAddOptions();
        handleAddChoice();
    }

    /**
     * Displays available vehicle types to add.
     */
    private static void displayAddOptions() {
        System.out.println("\n--- Add Vehicle ---");

        final String menuFormat = "\t%s%d. %s%s%n";

        System.out.printf(menuFormat, ConsoleColors.RED, AddOption.CAR, VehicleType.CAR, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.YELLOW, AddOption.MOPED, VehicleType.MOPED, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.BLUE, AddOption.SEMI_TRUCK, VehicleType.SEMI_TRUCK, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.PURPLE, AddOption.HOVERCRAFT, VehicleType.HOVERCRAFT, ConsoleColors.RESET);
        System.out.printf(menuFormat, ConsoleColors.GREEN, AddOption.BACK, "Back to Main Menu", ConsoleColors.RESET);
    }

    /**
     * Handles user's add choice and prompts for vehicle details.
     */
    private static void handleAddChoice() {
        int choice = ConsoleUtil.getUserIntInput("\nSelect vehicle type to add: ");

        ConsoleUtil.clearScreen();

        switch (choice) {
            case AddOption.CAR -> addCar();
            case AddOption.MOPED -> addMoped();
            case AddOption.SEMI_TRUCK -> addSemiTruck();
            case AddOption.HOVERCRAFT -> addHovercraft();
            case AddOption.BACK -> {} // Return to main menu
            default -> System.out.printf("Invalid choice. Please enter a number between %d and %d.%n",
                    AddOption.MIN_OPTION, AddOption.MAX_OPTION);
        }

        if (choice != AddOption.BACK) {
            ConsoleUtil.waitAndContinue();
        }
    }

    /**
     * Prompts user for car details and adds to inventory.
     */
    private static void addCar() {
        System.out.println("--- Add New Car ---\n");

        int numPassengers = ConsoleUtil.getUserIntInput("Number of passengers: ");
        int cargoCapacity = ConsoleUtil.getUserIntInput("Cargo capacity (lbs): ");
        int fuelCapacity = ConsoleUtil.getUserIntInput("Fuel capacity (gal): ");
        String color = ConsoleUtil.getUserInput("Color: ");
        String make = ConsoleUtil.getUserInput("Make: ");
        String model = ConsoleUtil.getUserInput("Model: ");
        int numDoors = ConsoleUtil.getUserIntInput("Number of doors: ");

        Car car = new Car(numPassengers, cargoCapacity, fuelCapacity, color, make, model, numDoors);
        boolean success = Inventory.addVehicle(car);

        displayAddResult(success, make + " " + model);
    }

    /**
     * Prompts user for moped details and adds to inventory.
     */
    private static void addMoped() {
        System.out.println("--- Add New Moped ---\n");

        int numPassengers = ConsoleUtil.getUserIntInput("Number of passengers: ");
        int cargoCapacity = ConsoleUtil.getUserIntInput("Cargo capacity (lbs): ");
        int fuelCapacity = ConsoleUtil.getUserIntInput("Fuel capacity (gal): ");
        String color = ConsoleUtil.getUserInput("Color: ");
        int topSpeed = ConsoleUtil.getUserIntInput("Top speed (mph): ");
        boolean hasBasket = ConsoleUtil.getUserBooleanInput("Has basket?");

        Moped moped = new Moped(numPassengers, cargoCapacity, fuelCapacity, color, topSpeed, hasBasket);
        boolean success = Inventory.addVehicle(moped);

        displayAddResult(success, color + " moped");
    }

    /**
     * Prompts user for semi truck details and adds to inventory.
     */
    private static void addSemiTruck() {
        System.out.println("--- Add New Semi Truck ---\n");

        int numPassengers = ConsoleUtil.getUserIntInput("Number of passengers: ");
        int cargoCapacity = ConsoleUtil.getUserIntInput("Cargo capacity (lbs): ");
        int fuelCapacity = ConsoleUtil.getUserIntInput("Fuel capacity (gal): ");
        String color = ConsoleUtil.getUserInput("Color: ");
        String make = ConsoleUtil.getUserInput("Make: ");
        String model = ConsoleUtil.getUserInput("Model: ");
        int numAxles = ConsoleUtil.getUserIntInput("Number of axles: ");
        boolean hasSleeper = ConsoleUtil.getUserBooleanInput("Has sleeper cab?");

        SemiTruck truck = new SemiTruck(numPassengers, cargoCapacity, fuelCapacity, color,
                make, model, numAxles, hasSleeper);
        boolean success = Inventory.addVehicle(truck);

        displayAddResult(success, make + " " + model);
    }

    /**
     * Prompts user for hovercraft details and adds to inventory.
     */
    private static void addHovercraft() {
        System.out.println("--- Add New Hovercraft ---\n");

        int numPassengers = ConsoleUtil.getUserIntInput("Number of passengers: ");
        int cargoCapacity = ConsoleUtil.getUserIntInput("Cargo capacity (lbs): ");
        int fuelCapacity = ConsoleUtil.getUserIntInput("Fuel capacity (gal): ");
        String color = ConsoleUtil.getUserInput("Color: ");
        int fanPower = ConsoleUtil.getUserIntInput("Fan power (HP): ");
        boolean isAmphibious = ConsoleUtil.getUserBooleanInput("Is amphibious?");

        Hovercraft hovercraft = new Hovercraft(numPassengers, cargoCapacity, fuelCapacity, color,
                fanPower, isAmphibious);
        boolean success = Inventory.addVehicle(hovercraft);

        displayAddResult(success, color + " hovercraft");
    }

    /**
     * Displays the result of adding a vehicle to inventory.
     *
     * @param success whether the add operation was successful
     * @param vehicleDescription description of the vehicle added
     */
    private static void displayAddResult(boolean success, String vehicleDescription) {
        if (success) {
            System.out.printf("%n%sSuccessfully added %s to inventory!%s%n", ConsoleColors.GREEN_BOLD, vehicleDescription, ConsoleColors.RESET);
        } else {
            System.out.printf("%n%sFailed to add vehicle to inventory.%s%n", ConsoleColors.RED_BOLD, ConsoleColors.RESET);
        }
    }
}