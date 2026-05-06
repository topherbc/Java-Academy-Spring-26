package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    public double getPrice() {
        double price = 0;
        if (this.roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else  {
            price = 124.00;
        }

        if (this.isWeekend()) {
            price = price * 1.10; //increase by 10%
        }

        return price;
    }

    private double getReservationTotal() {
        return this.getPrice() * this.numberOfNights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }
}
