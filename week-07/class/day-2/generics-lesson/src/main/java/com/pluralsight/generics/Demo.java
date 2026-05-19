package com.pluralsight.generics;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Boolean> list = new ArrayList<>();

        Carrier<String> petNames = new Carrier<>(3);

        petNames.add("Fluffy");
        petNames.add("Spot");
        petNames.add("Whiskers");

        System.out.println("Pet names: " + petNames);
        System.out.println("First pet: " + petNames.get(0));
        System.out.println("Carrier full? " + petNames.isFull());


        boolean added = petNames.add("Rex");
        System.out.println("Added Rex? " + added);
        System.out.println();


        Carrier<Integer> petAges = new Carrier<>(3);

        petAges.add(3);
        petAges.add(7);
        petAges.add(2);

        System.out.println("Pet ages: " + petAges);

        // Calculate average age
        int sum = 0;
        for (int i = 0; i < petAges.size(); i++) {
            sum += petAges.get(i);
        }
        double averageAge = (double) sum / petAges.size();
        System.out.println("Average age: " + averageAge);
        System.out.println();



        Carrier<Double> petWeights = new Carrier<>(4);

        petWeights.add(8.5);
        petWeights.add(12.3);
        petWeights.add(5.7);

        System.out.println("Pet weights (lbs): " + petWeights);
        System.out.println("Number of pets: " + petWeights.size());
        System.out.println("Capacity remaining: " + (petWeights.capacity() - petWeights.size()));
        System.out.println();

        Carrier<String> stringCarrier = new Carrier<>(2);
        stringCarrier.add("This is a string");

//
        String text = stringCarrier.get(0);
        System.out.println("Retrieved: " + text);
        System.out.println("Length: " + text.length());
    }
}
