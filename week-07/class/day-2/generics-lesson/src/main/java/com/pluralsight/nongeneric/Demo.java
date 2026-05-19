package com.pluralsight.nongeneric;

/**
 * Demonstrates the use of the generic Carrier class with different types.
 * Shows how generics provide type safety and reusability.
 */
public class Demo {

    public static void main(String[] args) {

        CarrierOfIntegers petAges = new CarrierOfIntegers(3);

        petAges.add(8);
        petAges.add(7);
        petAges.add(2);
        petAges.add(6);

        System.out.println("Pet ages: " + petAges);
        System.out.println("First pet age: " + petAges.get(0));
        System.out.println("Carrier full? " + petAges.isFull());
        System.out.println();

        //Increase size
//        boolean added = petAges.add(5);
//        System.out.println("Added age 5? " + added);
//        System.out.println("Current size: " + petAges.size());
//        System.out.println("Capacity: " + petAges.capacity());
//        System.out.println();

        //Calculate Average
//        int sum = 0;
//        for (int i = 0; i < petAges.size(); i++) {
//            sum += petAges.get(i);
//        }
//        double averageAge = (double) sum / petAges.size();
//        System.out.println("Average age: " + averageAge + " years");
//        System.out.println();

    }
}