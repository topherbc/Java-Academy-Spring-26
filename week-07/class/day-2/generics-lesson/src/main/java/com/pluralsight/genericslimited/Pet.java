package com.pluralsight.genericslimited;

/**
 * Abstract base class representing a pet.
 * All specific pet types (Dog, Cat, Bird) extend this class.
 */
public abstract class Pet {
    private String name;
    private int age;

    /**
     * Creates a new Pet with the given name and age.
     * @param name the pet's name
     * @param age the pet's age in years
     */
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the pet's name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pet's age.
     * @return the age in years
     */
    public int getAge() {
        return age;
    }

    /**
     * Makes the pet make its characteristic sound.
     * Each pet type implements this differently.
     * @return the sound the pet makes
     */
    public abstract String makeSound();

    /**
     * Gets the type of pet (Dog, Cat, Bird, etc.)
     * @return the pet type as a string
     */
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " named " + name + " (age " + age + ")";
    }
}