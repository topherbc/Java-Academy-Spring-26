package com.pluralsight.models;

/**
 * Base class representing a Vehicle in the VIS application.
 * Provides common attributes and behavior for all vehicle types.
 */
public abstract class Vehicle implements Driveable, Sellable {

    private int numberOfPassengers, cargoCapacity, fuelCapacity;
    private String color;

    /**
     * Creates a new Vehicle with the specified attributes.
     *
     * @param numberOfPassengers the number of passengers the vehicle can hold
     * @param cargoCapacity the cargo capacity in pounds
     * @param fuelCapacity the fuel capacity in gallons
     * @param color the color of the vehicle
     */
    public Vehicle(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color) {
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
        this.color = color;
    }

    /**
     * Gets the number of passengers the vehicle can hold.
     *
     * @return the number of passengers
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Sets the number of passengers the vehicle can hold.
     *
     * @param numberOfPassengers the number of passengers
     */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Gets the cargo capacity in pounds.
     *
     * @return the cargo capacity
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Sets the cargo capacity in pounds.
     *
     * @param cargoCapacity the cargo capacity
     */
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Gets the fuel capacity in gallons.
     *
     * @return the fuel capacity
     */
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the fuel capacity in gallons.
     *
     * @param fuelCapacity the fuel capacity
     */
    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the vehicle.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Simulates the vehicle driving.
     * Should be overridden by subclasses for specific behavior.
     */
    public abstract void drive();

    /**
     * Returns a string representation of the vehicle with its type and attributes.
     *
     * @return formatted string with vehicle information
     */
    @Override
    public String toString() {
        return String.format("Vehicle Type: %s\n\tColor: %s\n\tCargo Capacity: %d\n\tFuel Capacity: %d",
                this.getClass().getSimpleName(), this.color, this.cargoCapacity, this.fuelCapacity);
    }
}