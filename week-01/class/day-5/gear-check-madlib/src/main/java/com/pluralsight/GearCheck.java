package com.pluralsight;

import java.util.Scanner;

public class GearCheck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Gear Cache Check ===");

        System.out.print("Enter your name, climber: ");
        String climberName = scanner.nextLine();

        System.out.print("Enter your starting altitude: ");
        int climberAlt = scanner.nextInt();

        scanner.nextLine(); //when nextInt, it doesn't handle the  new line character //consume the CRLF

        String[] gear = new String[]{"Crampon Set", "Ice Axe", "Headlamp"};


        String selectedGear = gear[0];

        System.out.println("Checking gear: " + selectedGear);

        if (selectedGear.equals("Ice Axe")) {
            System.out.println(climberName + " (" + climberAlt + " m) -- " + selectedGear + " is available. Cleared for ascent.");
        }
        else {
            System.out.println(climberName + " (" + climberAlt + " m) -- " + selectedGear + " is not available. Climber is grounded.");
        }

        scanner.close();
    }
}
