package com.pluralsight.data;

import com.pluralsight.constants.VehicleType;
import com.pluralsight.models.*;

/**
 * Utility class for parsing CSV data into Vehicle objects.
 * Handles the conversion of pipe-delimited strings into specific vehicle types.
 */
public class CsvParser {
    private static final String PIPE_DELIMITER = "\\|";

    /**
     * Private constructor to prevent instantiation.
     */
    private CsvParser() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    /**
     * Converts a vehicle object to CSV format.
     *
     * @param vehicle the vehicle to convert
     * @return CSV string representation of the vehicle
     */
    public static String convertVehicleToCsv(Vehicle vehicle) {
        StringBuilder csv = new StringBuilder();

        // Common fields
        csv.append(vehicle.getClass().getSimpleName()).append("|");
        csv.append(vehicle.getNumberOfPassengers()).append("|");
        csv.append(vehicle.getCargoCapacity()).append("|");
        csv.append(vehicle.getFuelCapacity()).append("|");
        csv.append(vehicle.getColor());

        // Type-specific fields
        if (vehicle instanceof Car car) {
            csv.append("|").append(car.getMake());
            csv.append("|").append(car.getModel());
            csv.append("|").append(car.getNumDoors());
        } else if (vehicle instanceof Moped moped) {
            csv.append("|").append(moped.getTopSpeed());
            csv.append("|").append(moped.isHasBasket());
        } else if (vehicle instanceof SemiTruck truck) {
            csv.append("|").append(truck.getMake());
            csv.append("|").append(truck.getModel());
            csv.append("|").append(truck.getNumAxles());
            csv.append("|").append(truck.isHasSleeper());
        } else if (vehicle instanceof Hovercraft hovercraft) {
            csv.append("|").append(hovercraft.getFanPower());
            csv.append("|").append(hovercraft.isAmphibious());
        }

        return csv.toString();
    }

    /**
     * Creates a vehicle object from a CSV line.
     *
     * @param line the CSV line to parse
     * @return the created vehicle, or null if type is invalid
     */
    public static Vehicle parseVehicle(String line) {
        String[] parts = line.split(PIPE_DELIMITER);

        return switch (parts[0]) {
            case VehicleType.CAR -> parseCar(parts);
            case VehicleType.MOPED -> parseMoped(parts);
            case VehicleType.SEMI_TRUCK -> parseSemiTruck(parts);
            case VehicleType.HOVERCRAFT -> parseHovercraft(parts);
            default -> null;
        };
    }

    /**
     * Parses CSV parts into a Car object.
     *
     * @param parts the CSV parts array
     * @return a new Car object
     */
    private static Car parseCar(String[] parts) {
        return new Car(
                Integer.parseInt(parts[1]),  // numPassengers
                Integer.parseInt(parts[2]),  // cargoCapacity
                Integer.parseInt(parts[3]),  // fuelCapacity
                parts[4],                     // color
                parts[5],                     // make
                parts[6],                     // model
                Integer.parseInt(parts[7])   // numDoors
        );
    }

    /**
     * Parses CSV parts into a Moped object.
     *
     * @param parts the CSV parts array
     * @return a new Moped object
     */
    private static Moped parseMoped(String[] parts) {
        return new Moped(
                Integer.parseInt(parts[1]),      // numPassengers
                Integer.parseInt(parts[2]),      // cargoCapacity
                Integer.parseInt(parts[3]),      // fuelCapacity
                parts[4],                         // color
                Integer.parseInt(parts[5]),      // topSpeed
                Boolean.parseBoolean(parts[6])   // hasBasket
        );
    }

    /**
     * Parses CSV parts into a SemiTruck object.
     *
     * @param parts the CSV parts array
     * @return a new SemiTruck object
     */
    private static SemiTruck parseSemiTruck(String[] parts) {
        return new SemiTruck(
                Integer.parseInt(parts[1]),      // numPassengers
                Integer.parseInt(parts[2]),      // cargoCapacity
                Integer.parseInt(parts[3]),      // fuelCapacity
                parts[4],                         // color
                parts[5],                         // make
                parts[6],                         // model
                Integer.parseInt(parts[7]),      // numAxles
                Boolean.parseBoolean(parts[8])   // hasSleeper
        );
    }

    /**
     * Parses CSV parts into a Hovercraft object.
     *
     * @param parts the CSV parts array
     * @return a new Hovercraft object
     */
    private static Hovercraft parseHovercraft(String[] parts) {
        return new Hovercraft(
                Integer.parseInt(parts[1]),      // numPassengers
                Integer.parseInt(parts[2]),      // cargoCapacity
                Integer.parseInt(parts[3]),      // fuelCapacity
                parts[4],                         // color
                Integer.parseInt(parts[5]),      // fanPower
                Boolean.parseBoolean(parts[6])   // isAmphibious
        );
    }
}