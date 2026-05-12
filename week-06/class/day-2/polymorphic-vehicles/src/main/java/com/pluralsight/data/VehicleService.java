package com.pluralsight.data;

import com.pluralsight.models.*;

import java.util.ArrayList;

/**
 * Service class for vehicle operations in the VIS application.
 * Provides search and filter functionality for vehicles.
 */
public class VehicleService {

    /**
     * Private constructor to prevent instantiation.
     */
    private VehicleService() {
        throw new AssertionError("Cannot instantiate service class");
    }

    /**
     * Searches for vehicles by color.
     *
     * @param color the color to search for
     * @return ArrayList of vehicles matching the color
     */
    public static ArrayList<Vehicle> searchByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : InventoryManager.getAllVehicles()) {
            if (v.getColor().equalsIgnoreCase(color)) {
                results.add(v);
            }
        }

        return results;
    }

    /**
     * Searches for vehicles by type.
     *
     * @param type the vehicle type to search for
     * @return ArrayList of vehicles matching the type
     */
    public static ArrayList<Vehicle> searchByType(String type) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : InventoryManager.getAllVehicles()) {
            if (v.getClass().getSimpleName().equalsIgnoreCase(type)) {
                results.add(v);
            }
        }

        return results;
    }

    /**
     * Searches for vehicles by make (Cars and SemiTrucks only).
     *
     * @param make the make to search for
     * @return ArrayList of vehicles matching the make
     */
    public static ArrayList<Vehicle> searchByMake(String make) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : InventoryManager.getAllVehicles()) {
            if (v instanceof Car car) {
                if (car.getMake().equalsIgnoreCase(make)) {
                    results.add(car);
                }
            } else if (v instanceof SemiTruck truck) {
                if (truck.getMake().equalsIgnoreCase(make)) {
                    results.add(truck);
                }
            }
        }

        return results;
    }

    /**
     * Searches for vehicles by passenger count.
     *
     * @param minPassengers minimum number of passengers
     * @return ArrayList of vehicles with at least the specified passenger count
     */
    public static ArrayList<Vehicle> searchByPassengerCount(int minPassengers) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle v : InventoryManager.getAllVehicles()) {
            if (v.getNumberOfPassengers() >= minPassengers) {
                results.add(v);
            }
        }

        return results;
    }

    /**
     * Gets a random vehicle of the specified type.
     *
     * @param type the type of vehicle to retrieve
     * @return a random vehicle of the specified type, or null if none found
     */
    public static Vehicle getRandomVehicleByType(String type) {
        ArrayList<Vehicle> filtered = searchByType(type);

        if (filtered.isEmpty()) {
            return null;
        }

        return filtered.get((int) (Math.random() * filtered.size()));
    }
}