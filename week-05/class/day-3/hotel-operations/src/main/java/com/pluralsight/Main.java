package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Room room101 = new Room(2, 159.00, false, false);
        Room room201 = new Room(2, 159.00, false, false);

       room201.checkIn();

        System.out.println(room201.isAvailable());

    }
}
