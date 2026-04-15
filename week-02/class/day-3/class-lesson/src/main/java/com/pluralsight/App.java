package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String name =  scanner.nextLine();

        //To Classify

        //Issues presented, when having numerous variables establishing the same classification

        //Class - organized collection of data


        //instantiate == new
        //new instance

        //Access Modifiers = public v private
        //levels of encapsulation

        Person taryn = new Person("taryn", 67, "drawing");

        Person polina = new Person("Polina", 12, "reading books");

        Person justine = new Person("Justine", 29, "golf");

        Person cameron = new Person("Cameron", 10, "beyblader");

        //dot notation
//        System.out.println(taryn.getName());

//        System.out.println(polina.getHobby("hello"));
//        System.out.println(polina.getHobby(10));

//        System.out.println("WHY ");

        add(5, 5); //invokes add with int params
        add(5.5, 5.5); //invoke add with double params
    }

    public static void add(int x, int y) {
        System.out.println(x + y);
    }

    public static void add(double x, double y) {
        System.out.println(x + y);
    }

    public static void add(String x, String y) {
        System.out.println(x + y);
    }

}
