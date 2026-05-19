package com.pluralsight.genericslimited;

/**
 * Represents a Bird, which is a type of Pet.
 */
public class Bird extends Pet {
    private boolean canFly;

    /**
     * Creates a new Bird.
     * @param name the bird's name
     * @param age the bird's age
     * @param canFly whether the bird can fly
     */
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    /**
     * Checks if this bird can fly.
     * @return true if the bird can fly
     */
    public boolean canFly() {
        return canFly;
    }

    @Override
    public String makeSound() {
        return "Chirp!";
    }

    @Override
    public String getType() {
        return "Bird";
    }

    @Override
    public String toString() {
        String flyStatus = canFly ? "can fly" : "cannot fly";
        return super.toString() + " [" + flyStatus + "]";
    }
}