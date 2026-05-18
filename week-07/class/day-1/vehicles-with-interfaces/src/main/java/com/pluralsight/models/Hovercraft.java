package com.pluralsight.models;

import com.pluralsight.constants.ConsoleColors;

/**
 * Represents a Hovercraft in the VIS application.
 * Extends the Vehicle class with hovercraft-specific attributes.
 */
public class Hovercraft extends Vehicle {
    private int fanPower;
    private boolean isAmphibious;

    /**
     * Creates a new Hovercraft with the specified attributes.
     *
     * @param numberOfPassengers the number of passengers the hovercraft can hold
     * @param cargoCapacity the cargo capacity in pounds
     * @param fuelCapacity the fuel capacity in gallons
     * @param color the color of the hovercraft
     * @param fanPower the power of the fans in horsepower
     * @param isAmphibious whether the hovercraft can travel on both land and water
     */
    public Hovercraft(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color,
                      int fanPower, boolean isAmphibious) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
        this.fanPower = fanPower;
        this.isAmphibious = isAmphibious;
    }

    /**
     * Gets the fan power in horsepower.
     *
     * @return the fan power
     */
    public int getFanPower() {
        return fanPower;
    }

    /**
     * Sets the fan power in horsepower.
     *
     * @param fanPower the fan power
     */
    public void setFanPower(int fanPower) {
        this.fanPower = fanPower;
    }

    /**
     * Checks if the hovercraft is amphibious.
     *
     * @return true if amphibious, false otherwise
     */
    public boolean isAmphibious() {
        return isAmphibious;
    }

    /**
     * Sets whether the hovercraft is amphibious.
     *
     * @param amphibious true if amphibious, false otherwise
     */
    public void setAmphibious(boolean amphibious) {
        isAmphibious = amphibious;
    }

    /**
     * Simulates the hovercraft driving with specific details about fan power and terrain capability.
     */
    @Override
    public void drive() {
        String amphibiousInfo = isAmphibious ? " seamlessly transitioning from land to water" : " gliding across land";
        System.out.printf("The %s hovercraft hovers above the ground with %d HP of fan power%s! " +
                        "Carrying %d passengers and %d lbs of cargo, it uses %d gallons of fuel to defy friction itself.%n",
                getColor(), fanPower, amphibiousInfo, getNumberOfPassengers(), getCargoCapacity(), getFuelCapacity());
    }

    /**
     * Returns a string representation of the hovercraft with all its attributes.
     *
     * @return formatted string with hovercraft information
     */
    @Override
    public String toString() {
        return String.format("""
            %sVehicle Type: Hovercraft%s
            \tColor: %s
            \tFan Power: %d HP
            \tAmphibious: %s
            \tCargo Capacity: %d lbs
            \tFuel Capacity: %d gal
            \tPassengers: %d""",
                ConsoleColors.PURPLE_BOLD, ConsoleColors.RESET,
                getColor(), fanPower, (isAmphibious ? "Yes" : "No"),
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