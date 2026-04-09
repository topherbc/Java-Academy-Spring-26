package com.pluralsight;

public class OutputLesson {
    public static void main(String[] args) {
        System.out.print("Hello"); //without a new line
        System.out.print("World\n"); //prints on same line, with /n injected (new line)
        // /n is new line character
        // / <- escape character
        System.out.println("Hey thanks Noah"); //print with a newline
        System.out.println("and thank you Cameron");


        float subtotal = 22.80f;
        float tax = subtotal * 0.0825f;
        float totalDue = subtotal + tax;
        String aggregateName = "Total Due";

        int reallyGreatNumber = 14;

        //%s - accept the first String and place it here
        //%f
        System.out.printf("%s is: $%.0f\n", aggregateName, totalDue);
        System.out.printf("Our super awesome number is: %s \n", "Jihad");
        System.out.print("Wheres this go?");

        System.out.println("TotalDue: " + totalDue);

    }
}
