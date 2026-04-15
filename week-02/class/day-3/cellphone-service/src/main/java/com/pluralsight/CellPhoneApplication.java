package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); //Creates a new instance of Scanner
        //Instances = Objects

        CellPhone generatedCellPhone1 = new CellPhone();

        CellPhone generatedCellPhone2 = new CellPhone(123, "808-888-4343", "me", "iPhone", "Verizon");

        System.out.print("What is the serial number? ");

        generatedCellPhone1.setSerialNumber(userInput.nextInt());
        userInput.nextLine(); //Handles newline character

        System.out.print("What model is the phone? ");
        String model = userInput.nextLine();
        generatedCellPhone1.setModel();

        System.out.print("What carrier is the phone? ");
        generatedCellPhone1.setCarrier(userInput.nextLine());

        System.out.print("What number is the phone? ");
        generatedCellPhone1.setPhoneNumber(userInput.nextLine());

        System.out.print("What owner is the phone? ");
        generatedCellPhone1.setOwner(userInput.nextLine());

//        generatedCellPhone1.;


        display(generatedCellPhone1);
        System.out.println("THIS IS SECOND PHONE BELOW");
        display(generatedCellPhone2);

    }

    public static void display(CellPhone phone) {
        System.out.println("Phone Information: ");
        System.out.println("The Serial Number: " + phone.getSerialNumber());
        System.out.println("The Model: " + phone.getModel());
        System.out.println("The Carrier: " + phone.getCarrier());
        System.out.println("The Number: " + phone.getPhoneNumber());
        System.out.println("The Owner: " + phone.getOwner());
        phone.dial("808-555-2211");
    }
}
