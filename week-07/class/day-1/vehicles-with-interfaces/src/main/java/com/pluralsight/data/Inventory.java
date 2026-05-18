package com.pluralsight.data;

import com.pluralsight.models.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Manages the vehicle inventory for the VIS application.
 * Handles loading and saving vehicle data from/to CSV file.
 */
public class Inventory {
    private static final String FILE_PATH = "src/main/resources/inventory.csv";
    private static ArrayList<Vehicle> allVehicles = null;

    /**
     * Private constructor to prevent instantiation.
     */
    private Inventory() {
        throw new AssertionError("Cannot instantiate inventory class");
    }

    /**
     * Gets all vehicles in the inventory.
     * Loads vehicles from CSV if not already loaded.
     *
     * @return ArrayList of all vehicles
     */
    public static ArrayList<Vehicle> getAllVehicles() {
        if (allVehicles == null) {
            loadVehicles();
        }
        return allVehicles;
    }

    /**
     * Adds a vehicle to the inventory and saves to CSV file.
     *
     * @param vehicle the vehicle to add
     * @return true if successfully added, false otherwise
     */
    public static boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            return false;
        }

        getAllVehicles().add(vehicle);
        return saveVehicleToFile(vehicle);
    }

    /**
     * Loads vehicles from the CSV file into memory.
     * Uses CsvParser to convert each line into a Vehicle object.
     * Caches the results to avoid repeated file reads.
     */
    private static void loadVehicles() {
        if (allVehicles != null) {
            return;
        }

        allVehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                Vehicle vehicle = CsvParser.parseVehicle(line);
                if (vehicle != null) {
                    allVehicles.add(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading vehicles from " + FILE_PATH + ": " + e.getMessage());
        }
    }

    /**
     * Appends a vehicle to the CSV file.
     *
     * @param vehicle the vehicle to save
     * @return true if successfully saved, false otherwise
     */
    private static boolean saveVehicleToFile(Vehicle vehicle) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String csvLine = CsvParser.convertVehicleToCsv(vehicle);
            bw.write("\n" + csvLine);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving vehicle to " + FILE_PATH + ": " + e.getMessage());
            return false;
        }
    }
}