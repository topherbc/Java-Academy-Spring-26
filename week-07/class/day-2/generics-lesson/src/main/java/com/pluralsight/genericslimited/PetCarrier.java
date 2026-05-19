package com.pluralsight.genericslimited;

/**
 * A generic container that holds a fixed number of Pets
 * Uses a bounded type parameter to ensure only Pet types can be stored.
 *
 * @param <T> the type of Pet this carrier holds (must extend Pet)
 */
public class PetCarrier<T extends Pet> {
    private Object[] items;
    private int size;
    private int capacity;

    /**
     * Creates a new PetCarrier with the specified capacity.
     * @param capacity the maximum number of pets this carrier can hold
     */
    public PetCarrier(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.size = 0;
    }

    /**
     * Adds a pet to the carrier if there's space.
     * @param pet the pet to add
     * @return true if the pet was added, false if the carrier is full
     */
    public boolean add(T pet) {
        if (size >= capacity) {
            return false;
        }
        items[size] = pet;
        size++;
        return true;
    }

    /**
     * Gets the pet at the specified index.
     * @param index the position of the pet to retrieve
     * @return the pet at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) items[index];
    }

    /**
     * Returns the current number of pets in the carrier.
     * @return the number of pets currently stored
     */
    public int size() {
        return size;
    }

    /**
     * Returns the maximum capacity of this carrier.
     * @return the maximum number of pets this carrier can hold
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Checks if the carrier is full.
     * @return true if no more pets can be added
     */
    public boolean isFull() {
        return size >= capacity;
    }

    /**
     * Checks if the carrier is empty.
     * @return true if there are no pets in the carrier
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Makes all the pets in the carrier make their sounds.
     * This method demonstrates that we can call Pet methods on our generic type!
     */
    public void makeAllSounds() {
        System.out.println("Pets in carrier say:");
        for (int i = 0; i < size; i++) {
            T pet = (T) items[i];
            System.out.println("  " + pet.getName() + ": " + pet.makeSound());
        }
    }

    /**
     * Calculates the average age of all pets in the carrier.
     * @return the average age, or 0 if carrier is empty
     */
    public double getAverageAge() {
        if (size == 0) {
            return 0;
        }
        int totalAge = 0;
        for (int i = 0; i < size; i++) {
            T pet = (T) items[i];
            totalAge += pet.getAge();
        }
        return (double) totalAge / size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PetCarrier[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
