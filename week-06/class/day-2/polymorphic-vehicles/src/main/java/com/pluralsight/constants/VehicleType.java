package com.pluralsight.constants;

/**
 * Constants for vehicle type names used throughout the VIS application.
 * Provides consistent type strings for vehicle classification and identification.
 */
public class VehicleType {
    public static final String CAR = "Car";
    public static final String MOPED = "Moped";
    public static final String SEMI_TRUCK = "SemiTruck";
    public static final String HOVERCRAFT = "Hovercraft";

    /**
     * Private constructor to prevent instantiation.
     * This class should only be used for its static constants.
     */
    private VehicleType() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}