package com.pluralsight;

public class App {
    public static void main(String[] args) {
        String message = "A fun message";
        System.out.println(message);

        printStuff(message); //<- Invoking or Calling
    }

    public static void printStuff(String note) {
        System.out.println(note + ": added message onto the provided note");
    }
}
