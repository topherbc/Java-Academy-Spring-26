package com.pluralsight.generics;

/**
 * A generic container that holds a fixed number of items.
 * Once created, the capacity cannot be changed.
 *
 * @param <T> the type of items this carrier holds
 */
public class Carrier<T> {
    private Object[] items;
    private int size;
    private int capacity;

    /**
     * Creates a new Carrier with the specified capacity.
     * @param capacity the maximum number of items this carrier can hold
     */
    public Carrier(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.size = 0;
    }

    /**
     * Adds an item to the carrier if there's space.
     * @param item the item to add
     * @return true if the item was added, false if the carrier is full
     */
    public boolean add(T item) {
        if (size >= capacity) {
            return false;
        }
        items[size] = item;
        size++;
        return true;
    }

    /**
     * Gets the item at the specified index.
     * @param index the position of the item to retrieve
     * @return the item at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) items[index];
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
        StringBuilder sb = new StringBuilder("Carrier[");
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
