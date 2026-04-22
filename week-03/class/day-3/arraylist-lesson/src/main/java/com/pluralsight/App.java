package com.pluralsight;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        arrayLesson();
        arrayListLesson();
    }

    public static void arrayLesson() {
        String[] farmAnimals = new String[5];

        farmAnimals[0] = "Cow";
        farmAnimals[1] = "Pig";
        farmAnimals[2] = "Chicken";
        farmAnimals[3] = "Horse";
        farmAnimals[4] = "Sheep";

        System.out.println("Farm Animals (Array)");

        for (int i = 0; i < farmAnimals.length; i++) {
            System.out.println(i + ": " + farmAnimals[i]);
        }
    }


    public static void arrayListLesson() {
        ArrayList<String> farmAnimals = new ArrayList<>();

        farmAnimals.add("Cow");
        farmAnimals.add("Pig");
        farmAnimals.add("Chicken");
        farmAnimals.add("Horse");
        farmAnimals.add("Sheep");

        System.out.println("Farm Animals (ArrayList)");
        for (int i = 0; i < farmAnimals.size(); i++) {
            System.out.println(i + ": " + farmAnimals.get(i));
        }

        // Add at a specific index
        farmAnimals.add(2, "Goat");
        System.out.println("\nAfter add(2, Goat): " + farmAnimals);

        // Remove by index
        farmAnimals.remove(0);
        System.out.println("After remove(0):     " + farmAnimals);

        // Remove by value
        farmAnimals.remove("Sheep");
        System.out.println("After remove(Sheep): " + farmAnimals);

        // Check if a value exists
        System.out.println("\nContains 'Pig':  " + farmAnimals.contains("Pig"));
        System.out.println("Contains 'Duck': " + farmAnimals.contains("Duck"));

        // Get size
        System.out.println("Size: " + farmAnimals.size());

        // Get by index
        System.out.println("Index 1: " + farmAnimals.get(1));

        // Update by index
        farmAnimals.set(1, "Donkey");
        System.out.println("\nAfter set(1, Donkey): " + farmAnimals);

        // Clear the list
        farmAnimals.clear();
        System.out.println("After clear(), isEmpty: " + farmAnimals.isEmpty());
    }
}