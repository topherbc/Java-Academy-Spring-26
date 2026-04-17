package com.pluralsight;

import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the inventory management system");

        boolean run = true;
        while (run) {
            System.out.println("Please pick a number from one of the following options:");

            System.out.println("\t1) Cow");
            System.out.println("\t2) Chicken");
            System.out.println("\t3) Pig");
            System.out.println("\t4) Skunk");
            System.out.println("\t0) Exit App");
            System.out.print("Enter Selection: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Moo");
                    break;
                case 2:
                    System.out.println("Cluck");
                    break;
                case 3:
                    System.out.println("Oink");
                    break;
                case 4:
                    System.out.println("Le beau, le charmant, Le Pew");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("You're expecting something");
                    break;
            }

        switch (option) {
            case 1 -> {
                System.out.println("Moo");
                System.out.println("Moo");
                System.out.println("Moo");
                System.out.println("Moo");
                System.out.println("Moo");
            }
            case 2 -> System.out.println("Cluck");
            case 3 -> System.out.println("Oink");
            case 4 -> System.out.println("Le beau, le charmant, Le Pew");
        }
        }
    }
}
