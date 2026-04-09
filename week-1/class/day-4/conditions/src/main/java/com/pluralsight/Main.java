package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        boolean isPassed = true;
        boolean vibeCheck = false;
        String firstName = "COOL";
        String anotherName = "co";
        anotherName += "ol";

        System.out.println(firstName);
        System.out.println(anotherName);


        if (firstName.equalsIgnoreCase(anotherName)) {
            System.out.println("Yes they are");
        }

        //&& -- and, both conditions must be true
        //|| -- or, either condition must be true
        //== for int, double, float, all primitive types
        //.equals() or .equalsIgnoreCase() -> for Strings

        if (isPassed || vibeCheck) {
            System.out.println("Yes we've passed the check");
        } else {
            System.out.println("No");
        }

    }
}
