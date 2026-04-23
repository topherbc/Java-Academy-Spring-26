package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;

public class Lesson {
    public static void main(String[] args) {
//        arrayListLesson();
        hashMapLesson();
    }

    public static void arrayListLesson() {
        ArrayList<String> farmAnimals = new ArrayList<>();

        farmAnimals.add("Cow"); //index 0
        farmAnimals.add("Pig"); //index 1
        farmAnimals.add("Chicken");
        farmAnimals.add("Horse");
        farmAnimals.add("Sheep");

        System.out.println("Farm Animals (ArrayList)");


        for (String animal : farmAnimals) {
            System.out.println(animal);
        }





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

    public static void hashMapLesson() {
        HashMap<Integer, String> students = new HashMap<Integer, String>();

        students.put(1, "Jihad");
        students.put(2, "Bryan");
        students.put(3, "Justine");

        HashMap<String, String> farmAnimals = new HashMap<>();

        farmAnimals.put("Cow", "Moo");
        farmAnimals.put("Pig", "Oink");
        farmAnimals.put("Chicken", "Cluck");
        farmAnimals.put("Horse", "Neigh");
        farmAnimals.put("Sheep", "Baa");

        System.out.println("Farm Animals (HashMap)");
//        System.out.println(farmAnimals.get("Chicken"));

        for (String animal : farmAnimals.values()) {
            System.out.println(animal + " says " + farmAnimals.get(animal));
        }

        // Add a new entry
        farmAnimals.put("Goat", "Maa");
        System.out.println("\nAfter put(Goat, Maa): " + farmAnimals);

        // Update an existing key (put overwrites)
        farmAnimals.put("Pig", "OINK OINK");
        System.out.println("After updating Pig:   " + farmAnimals);

        // Get a value by key
        System.out.println("\nGet 'Cow':   " + farmAnimals.get("Cow"));

        // Check if a key exists
        System.out.println("containsKey('Horse'):  " + farmAnimals.containsKey("Horse"));
        System.out.println("containsKey('Duck'):   " + farmAnimals.containsKey("Duck"));

        // Check if a value exists
        System.out.println("containsValue('Moo'):  " + farmAnimals.containsValue("Moo"));

        // Remove by key
        farmAnimals.remove("Sheep");
        System.out.println("\nAfter remove(Sheep): " + farmAnimals);

        // Get size
        System.out.println("Size: " + farmAnimals.size());

        // Loop over values only
        System.out.println("\n--- values loop ---");
        for (String sound : farmAnimals.values()) {
            System.out.println(sound);
        }


        // Clear the map
        farmAnimals.clear();
        System.out.println("\nAfter clear(), isEmpty: " + farmAnimals.isEmpty());
    }
}
