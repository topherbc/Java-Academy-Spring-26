package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter your name");
        System.out.print("First Name: ");
        String firstName = keyboard.nextLine().trim();

        System.out.print("Middle Name: ");
        String middleName = keyboard.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = keyboard.nextLine().trim();


        System.out.print("Suffix: ");
        String suffix = keyboard.nextLine().trim();

        String fullName = "";

        //D.R.Y. method
        //DON'T REPEAT YOURSELF

        if (suffix.equalsIgnoreCase("") && middleName.equalsIgnoreCase("")) {
            fullName = firstName + " " + lastName;
        } else if (suffix.equalsIgnoreCase("")) {
            fullName = firstName + " " + middleName + " " + lastName;
        } else if (middleName.equalsIgnoreCase("")) {
            fullName = firstName + " " + lastName + ", " + suffix;
        } else {
            fullName = firstName + " " + middleName + " " + lastName + ", " + suffix;
        }

        System.out.println(fullName);
    }
}
