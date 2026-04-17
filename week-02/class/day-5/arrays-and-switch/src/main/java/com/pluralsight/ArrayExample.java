package com.pluralsight;

public class ArrayExample {
    public static void main(String[] args) throws InterruptedException {
        String[] animals = {"Cow", "Chicken", "Pig", "Skunk", "Hedgehog"};

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Animal " + (i+1) + ": " + animals[i]);
            Thread.sleep(1000);
        }

    }
}
