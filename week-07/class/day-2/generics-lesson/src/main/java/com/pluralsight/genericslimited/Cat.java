package com.pluralsight.genericslimited;

/**
 * Represents a Cat, which is a type of Pet.
 */
public class Cat extends Pet {
    private boolean isIndoor;

    /**
     * Creates a new Cat.
     * @param name the cat's name
     * @param age the cat's age
     * @param isIndoor whether the cat is an indoor cat
     */
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    /**
     * Checks if this is an indoor cat.
     * @return true if indoor, false if outdoor
     */
    public boolean isIndoor() {
        return isIndoor;
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public String toString() {
        String location = isIndoor ? "indoor" : "outdoor";
        return super.toString() + " [" + location + "]";
    }
}
