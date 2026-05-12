package com.pluralsight.models;

import com.pluralsight.constants.ConsoleColors;

/**
 * Represents a Car in the VIS application.
 * Extends the Vehicle class with car-specific attributes like make and model.
 */
public class Car extends Vehicle {
    private String make;
    private String model;
    private int numDoors;

    /**
     * Creates a new Car with the specified attributes.
     *
     * @param numberOfPassengers the number of passengers the car can hold
     * @param cargoCapacity the cargo capacity in pounds
     * @param fuelCapacity the fuel capacity in gallons
     * @param color the color of the car
     * @param make the manufacturer of the car
     * @param model the model name of the car
     * @param numDoors the number of doors on the car
     */
    public Car(int numberOfPassengers, int cargoCapacity, int fuelCapacity, String color, String make, String model, int numDoors) {
        super(numberOfPassengers, cargoCapacity, fuelCapacity, color);
        this.make = make;
        this.model = model;
        this.numDoors = numDoors;
    }

    /**
     * Gets the manufacturer of the car.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the manufacturer of the car.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model name of the car.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model name of the car.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the number of doors on the car.
     *
     * @return the number of doors
     */
    public int getNumDoors() {
        return numDoors;
    }

    /**
     * Sets the number of doors on the car.
     *
     * @param numDoors the number of doors
     */
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    /**
     * Simulates the car driving with specific details about make, model, and features.
     */
    @Override
    public void drive() {
        System.out.printf("The %s %s %s revs its engine and drives smoothly down the road with %d passengers inside. " +
                        "Its %d-door design provides easy access, and the %d gallon fuel tank ensures a long journey ahead.%n",
                getColor(), make, model, getNumberOfPassengers(), numDoors, getFuelCapacity());
    }

    /**
     * Returns a string representation of the car with all its attributes.
     *
     * @return formatted string with car information
     */
    @Override
    public String toString() {
        return String.format("""
            %s%sVehicle Type: Car%s
            \tMake: %s
            \tModel: %s
            \tColor: %s
            \tDoors: %d
            \tCargo Capacity: %d lbs
            \tFuel Capacity: %d gal
            \tPassengers: %d""",
                ConsoleColors.RED_BOLD, ConsoleColors.BOLD, ConsoleColors.RESET,
                make, model, getColor(), numDoors,
                getCargoCapacity(), getFuelCapacity(), getNumberOfPassengers());
    }
}