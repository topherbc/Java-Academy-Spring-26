package com.pluralsight;

public class App {
    public static void main(String[] args) {

        Person bryan = new Person("Bryan", 20, "3d printing");

        Person tyrail = new Person("Tyrail", 28, "gym");

        Person noah = new Person("Noah", 108, "sketching");

        System.out.println(noah.getHobby());
    }
}
