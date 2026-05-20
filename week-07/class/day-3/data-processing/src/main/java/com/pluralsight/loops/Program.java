package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    static ArrayList<Person> astronomers = new ArrayList<>();

    public static void main(String[] args) {
        loadAstronomers();
        printAll();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine().trim();
        scanner.close();

        List<Person> matches = searchByName(searchName);
        printMatches(matches, searchName);

        printAverageAge();
        printOldest();
        printYoungest();
    }

    public static void loadAstronomers() {
        astronomers.add(new Person("Nicolaus", "Copernicus", 70));
        astronomers.add(new Person("Galileo", "Galilei", 77));
        astronomers.add(new Person("Johannes", "Kepler", 58));
        astronomers.add(new Person("Isaac", "Newton", 84));
        astronomers.add(new Person("Edmond", "Halley", 85));
        astronomers.add(new Person("William", "Herschel", 83));
        astronomers.add(new Person("Edwin", "Hubble", 63));
        astronomers.add(new Person("Carl", "Sagan", 62));
        astronomers.add(new Person("Stephen", "Hawking", 76));
        astronomers.add(new Person("Neil", "Tyson", 65));
    }

    public static void printAll() {
        System.out.println("--- All Astronomers ---");
        astronomers.forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastname() + ", Age: " + p.getAge()));

        for (Person p : astronomers) {
            System.out.println(p.getFirstName() + " " + p.getLastname() + ", Age: " + p.getAge());
        }
    }

    public static List<Person> searchByName(String searchName) {
        List<Person> matches = new ArrayList<>();
        for (Person p : astronomers) {
            if (p.getFirstName().equalsIgnoreCase(searchName) || p.getLastname().equalsIgnoreCase(searchName)) {
                matches.add(p);
            }
        }
        return matches;
    }

    public static void printMatches(List<Person> matches, String searchName) {
        System.out.println("\n--- Search Results ---");
        if (matches.isEmpty()) {
            System.out.println("No matches found for: " + searchName);
        } else {
            for (Person p : matches) {
                System.out.println(p.getFirstName() + " " + p.getLastname());
            }
        }
    }

    public static void printAverageAge() {
        int totalAge = 0;
        for (Person p : astronomers) {
            totalAge += p.getAge();
        }
        double averageAge = (double) totalAge / astronomers.size();
        System.out.println("\n--- Age Statistics ---");
        System.out.printf("Average age: %.1f%n", averageAge);
    }

    public static void printOldest() {
        Person oldest = astronomers.get(0);
        for (Person p : astronomers) {
            if (p.getAge() > oldest.getAge()) {
                oldest = p;
            }
        }
        System.out.println("Oldest: " + oldest.getFirstName() + " " + oldest.getLastname()
                + " (Age: " + oldest.getAge() + ")");
    }

    public static void printYoungest() {
        Person youngest = astronomers.get(0);
        for (Person p : astronomers) {
            if (p.getAge() < youngest.getAge()) {
                youngest = p;
            }
        }
        System.out.println("Youngest: " + youngest.getFirstName() + " " + youngest.getLastname()
                + " (Age: " + youngest.getAge() + ")");
    }
}