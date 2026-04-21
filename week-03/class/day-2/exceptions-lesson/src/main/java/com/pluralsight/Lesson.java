package com.pluralsight;

import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Sadaqa", "Jihad", "Polina", "Bryan", "Jazz"};

        while(true) {
            try {
                System.out.print("Please enter a number between (0-4): ");
                int input = scanner.nextInt();

                System.out.println(students[input]);

                break; //Break out of loops
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Hey, issue with number; Try again");
            }
        }



    }
}
