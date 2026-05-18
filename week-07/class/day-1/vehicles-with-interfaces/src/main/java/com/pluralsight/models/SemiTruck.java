package com.pluralsight.models;

import com.pluralsight.constants.ConsoleColors;

/**
 * Represents a Semi Truck in the VIS application.
 * Extends the Vehicle class with semi truck-specific attributes.
 */
public class SemiTruck extends Vehicle {
    private String make;
    private String model;
    private int numAxles;
    private boolean hasSleeper;

    /**
     * Creates a new Semi Truck with the specified attributes.
     *
     * @param numberOfPassengers the number of passengers the semi truck can hold
     * @param cargoCapacity the cargo capacity in pounds
     * @param fuelCapacity the fuel capacity in gallons
     * @param color the color of the semi truck
     * @param make the manufacturer of the semi truck
     * @param model the model name of the semi truck
     * @param numAxles the number of axles on the truck
     * @param hasSleeper whether the truck has a sleeper cab
     */
    public SemiTruck(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color,
                     String make, String model, int numAxles, boolean hasSleeper) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
        this.make = make;
        this.model = model;
        this.numAxles = numAxles;
        this.hasSleeper = hasSleeper;
    }

    /**
     * Gets the manufacturer of the semi truck.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the manufacturer of the semi truck.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model name of the semi truck.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model name of the semi truck.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the number of axles on the truck.
     *
     * @return the number of axles
     */
    public int getNumAxles() {
        return numAxles;
    }

    /**
     * Sets the number of axles on the truck.
     *
     * @param numAxles the number of axles
     */
    public void setNumAxles(int numAxles) {
        this.numAxles = numAxles;
    }

    /**
     * Checks if the truck has a sleeper cab.
     *
     * @return true if has sleeper cab, false otherwise
     */
    public boolean isHasSleeper() {
        return hasSleeper;
    }

    /**
     * Sets whether the truck has a sleeper cab.
     *
     * @param hasSleeper true if has sleeper cab, false otherwise
     */
    public void setHasSleeper(boolean hasSleeper) {
        this.hasSleeper = hasSleeper;
    }

    /**
     * Simulates the semi truck driving with specific details about make, model, and features.
     */
    @Override
    public void drive() {
        String sleeperInfo = hasSleeper ? " The driver can rest comfortably in the sleeper cab during long hauls." : "";
        System.out.printf("The powerful %s %s %s rumbles down the highway on %d axles, hauling %d lbs of cargo. " +
                        "With %d gallons of diesel fuel, this beast is ready for cross-country transport!%s%n",
                getColor(), make, model, numAxles, getCargoCapacity(), getFuelCapacity(), sleeperInfo);
    }

    /**
     * Returns a string representation of the semi truck with all its attributes.
     *
     * @return formatted string with semi truck information
     */
    @Override
    public String toString() {
        return String.format("""
            %sVehicle Type: Semi Truck%s
            \tMake: %s
            \tModel: %s
            \tColor: %s
            \tAxles: %d
            \tSleeper Cab: %s
            \tCargo Capacity: %d lbs
            \tFuel Capacity: %d gal
            \tPassengers: %d""",
                ConsoleColors.BLUE_BOLD, ConsoleColors.RESET,
                make, model, getColor(), numAxles, (hasSleeper ? "Yes" : "No"),
                getCargoCapacity(), getFuelCapacity(), getNumberOfPassengers());
    }

    @Override
    public void accelerate(int pressure) {

    }

    @Override
    public void brake(int pressure) {

    }

    @Override
    public int steer(char direction) {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}