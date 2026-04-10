package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double regular = 5.45;
        double large = 8.95;
        double grandTotal = 0;
        double youngDiscount = 0.9;

        System.out.print("Please enter the size of the sandwich (1 for regular and 2 for large): ");
        String size = keyboard.nextLine();

        System.out.print("Enter your age for discount: ");
        int age = keyboard.nextInt();

        if (size.equals("r")) {
            grandTotal = regular;
        } else if (size.equals("l")){
            grandTotal = large;
        } else {
            System.out.println("WRONG OPTION START OVER");
        }

        if (age <= 17) {
            grandTotal*=youngDiscount;
        } else if (age >= 65) {
            grandTotal*=0.8;
        }

        System.out.println("Your order total: $" + grandTotal);

//        Display the cost of the sandwich to the screen
    }
}
