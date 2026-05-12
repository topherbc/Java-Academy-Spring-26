package com.pluralsight.ui;

import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.data.InventoryManager;
import com.pluralsight.data.VehicleService;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;

/**
 * Handles the display of vehicle information in the VIS application.
 * Provides methods to show individual vehicles or all vehicles in inventory.
 */
public class VehicleDisplay {

    /**
     * Displays all vehicles in the inventory.
     * Each vehicle is printed with a blank line separator.
     */
    public static void displayAll() {
        for (Vehicle vehicle : InventoryManager.getAllVehicles()) {
            System.out.println(vehicle);
            System.out.println();
        }
    }

    /**
     * Displays a random vehicle of the specified type and demonstrates its drive method.
     * Shows an error message if no vehicles of the type are found.
     *
     * @param type the type of vehicle to display (e.g., "Car", "Moped")
     */
    public static void displayRandomByType(String type) {
        Vehicle v = VehicleService.getRandomVehicleByType(type);

        if (v != null) {
            System.out.println(v);
            System.out.print("\nPolymorphic Method Call: ");
            v.drive();
        } else {
            System.out.println("No vehicles of type " + type + " found.");
        }
    }

    /**
     * Displays all vehicles matching the specified color.
     *
     * @param color the color to search for
     */
    public static void displayByColor(String color) {
        displaySearchResults(VehicleService.searchByColor(color), "color: " + color);
    }

    /**
     * Displays all vehicles matching the specified type.
     *
     * @param type the vehicle type to search for
     */
    public static void displayByType(String type) {
        displaySearchResults(VehicleService.searchByType(type), "type: " + type);
    }

    /**
     * Displays all vehicles matching the specified make.
     *
     * @param make the make to search for
     */
    public static void displayByMake(String make) {
        displaySearchResults(VehicleService.searchByMake(make), "make: " + make);
    }

    /**
     * Displays all vehicles with at least the specified passenger count.
     *
     * @param minPassengers minimum number of passengers
     */
    public static void displayByPassengerCount(int minPassengers) {
        displaySearchResults(VehicleService.searchByPassengerCount(minPassengers), "at least " + minPassengers + " passengers");
    }

    /**
     * Displays search results with a search criteria message.
     *
     * @param results the list of vehicles found
     * @param criteria the search criteria description
     */
    private static void displaySearchResults(ArrayList<Vehicle> results, String criteria) {
        if (results.isEmpty()) {
            System.out.println("No vehicles found with " + criteria);
        } else {
            System.out.printf("%sFound %d vehicle(s) with %s:%s%n%n", ConsoleColors.GREEN_BOLD, results.size(), criteria, ConsoleColors.RESET);
            for (Vehicle v : results) {
                System.out.println(v);
                System.out.println();
            }
        }
    }
}