package com.pluralsight.genericslimited;

/**
 * Represents a Dog, which is a type of Pet.
 */
public class Dog extends Pet {
    private String breed;

    /**
     * Creates a new Dog.
     * @param name the dog's name
     * @param age the dog's age
     * @param breed the dog's breed
     */
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    /**
     * Gets the dog's breed.
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }

    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String toString() {
        return super.toString() + " [" + breed + "]";
    }
}
