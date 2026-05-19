package com.pluralsight.nongeneric;

/**
 * A container that holds a fixed number of Integers.
 * Once created, the capacity cannot be changed.
 */
public class CarrierOfIntegers {
    private Integer[] items;
    private int size;
    private int capacity;

    /**
     * Creates a new CarrierOfIntegers with the specified capacity.
     * @param capacity the maximum number of items this carrier can hold
     */
    public CarrierOfIntegers(int capacity) {
        this.capacity = capacity;
        this.items = new Integer[capacity];
        this.size = 0;
    }

    /**
     * Adds an integer to the carrier if there's space.
     * @param item the integer to add
     * @return true if the item was added, false if the carrier is full
     */
    public boolean add(Integer item) {
        if (size >= capacity) {
            return false;
        }
        items[size] = item;
        size++;
        return true;
    }

    /**
     * Gets the integer at the specified index.
     * @param index the position of the item to retrieve
     * @return the integer at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[index];
    }

    /**
     * Returns the current number of items in the carrier.
     * @return the number of items currently stored
     */
    public int size() {
        return size;
    }

    /**
     * Returns the maximum capacity of this carrier.
     * @return the maximum number of items this carrier can hold
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Checks if the carrier is full.
     * @return true if no more items can be added
     */
    public boolean isFull() {
        return size >= capacity;
    }

    /**
     * Checks if the carrier is empty.
     * @return true if there are no items in the carrier
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarrierOfIntegers[");
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
