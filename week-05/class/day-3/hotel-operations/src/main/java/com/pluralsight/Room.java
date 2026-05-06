package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied, dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public boolean isAvailable() {
        return !this.isOccupied() && !this.isDirty();
    }

    public void checkIn() {
        this.occupied = true;
        this.dirty = true;
    }

    public void checkOut() {
        this.occupied = false;
    }

    public void cleanRoom() {
        this.dirty = false;
    }
}
