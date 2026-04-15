package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name =  scanner.nextLine();

        //To Classify

        //Issues presented, when having numerous variables establishing the same classification

        //Class - organized collection of data


        //instantiate == new
        //new instance

        //Default Access Modifiers = public v private
        //levels of encapsulation

        Person taryn = new Person(name, 67, "drawing");

        Person polina = new Person("Polina", 12, "reading books");

        Person justine = new Person("Justine", 29, "golf");

        Person cameron = new Person("Cameron", 10, "beyblader");

        //dot notation
        System.out.println(taryn.getName());

        System.out.println(polina.getHobby());


    }
}
