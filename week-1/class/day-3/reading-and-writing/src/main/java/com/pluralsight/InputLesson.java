package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class InputLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        println -- new line character /n

        System.out.print("Hey, please enter your name: ");
        String name = scanner.nextLine(); //expects to capture String before /n
        //CRLF - Carriage Return Line Feed

        System.out.println("Hey thanks " + name);

        System.out.print("Hey, please enter your height: ");
        int height = scanner.nextInt(); //only reads the int value
        scanner.nextLine(); //consume the CRLF

        System.out.println("Hey thats a height: " + height);

        System.out.print("Hey, please enter some words: ");
        String greatWords = scanner.nextLine();
        System.out.println("The words: " + greatWords);
    }
}
