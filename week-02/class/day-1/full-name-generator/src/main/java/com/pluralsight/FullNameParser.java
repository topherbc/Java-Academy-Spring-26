package com.pluralsight;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your full name: ");

        String fullName = sc.nextLine().trim();

        String[] splitName = fullName.split(Pattern.quote(" "));

        if (splitName.length > 2) { //I have middle name, because length is more than 2, 3 names
            System.out.println("First Name: " + splitName[0]);
            System.out.println("Middle Name: " + splitName[1]);
            System.out.println("Last Name: " + splitName[2]);
        } else {
            System.out.println("First Name: " + splitName[0]);
            System.out.println("Last Name: " + splitName[1]);
        }

    }
}
