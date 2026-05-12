package com.pluralsight.models;

import com.pluralsight.constants.ConsoleColors;

/**
 * Represents a Moped in the VIS application.
 * Extends the Vehicle class with moped-specific attributes.
 */
public class Moped extends Vehicle {
    private int topSpeed;
    private boolean hasBasket;

    /**
     * Creates a new Moped with the specified attributes.
     *
     * @param numberOfPassengers the number of passengers the moped can hold
     * @param cargoCapacity the cargo capacity in pounds
     * @param fuelCapacity the fuel capacity in gallons
     * @param color the color of the moped
     * @param topSpeed the maximum speed in mph
     * @param hasBasket whether the moped has a storage basket
     */
    public Moped(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color,
                 int topSpeed, boolean hasBasket) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
        this.topSpeed = topSpeed;
        this.hasBasket = hasBasket;
    }

    /**
     * Gets the maximum speed in mph.
     *
     * @return the top speed
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * Sets the maximum speed in mph.
     *
     * @param topSpeed the top speed
     */
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    /**
     * Checks if the moped has a storage basket.
     *
     * @return true if has basket, false otherwise
     */
    public boolean isHasBasket() {
        return hasBasket;
    }

    /**
     * Sets whether the moped has a storage basket.
     *
     * @param hasBasket true if has basket, false otherwise
     */
    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    /**
     * Simulates the moped driving with specific details about speed and features.
     */
    @Override
    public void drive() {
        String basketInfo = hasBasket ? " with a convenient basket for carrying groceries" : " zipping through traffic";
        System.out.printf("The %s moped putters along at a modest %d mph%s. " +
                        "Its compact size holds %d lbs of cargo and uses only %d gallons of fuel for maximum efficiency!%n",
                getColor(), topSpeed, basketInfo, getCargoCapacity(), getFuelCapacity());
    }

    /**
     * Returns a string representation of the moped with all its attributes.
     *
     * @return formatted string with moped information
     */
    @Override
    public String toString() {
        return String.format("""
            %sVehicle Type: Moped%s
            \tColor: %s
            \tTop Speed: %d mph
            \tHas Basket: %s
            \tCargo Capacity: %d lbs
            \tFuel Capacity: %d gal
            \tPassengers: %d""",
                ConsoleColors.YELLOW_BOLD, ConsoleColors.RESET,
                getColor(), topSpeed, (hasBasket ? "Yes" : "No"),
                getCargoCapacity(), getFuelCapacity(), getNumberOfPassengers());
    }
}