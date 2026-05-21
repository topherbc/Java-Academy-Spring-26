package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        astronomers.forEach(System.out::println);
//        astronomers.forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastname() + ", Age: " + p.getAge()));
    }

    public static List<Person> searchByName(String searchName) {
        return astronomers.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(searchName) || p.getLastname().equalsIgnoreCase(searchName))
                .collect(Collectors.toList());
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
        double averageAge = astronomers.stream()
                .mapToDouble(p -> p.getAge())
                .average().getAsDouble();

        System.out.println("\n--- Age Statistics ---");
        System.out.printf("Average age: %.1f%n", averageAge);
    }

    public static void printOldest() {
        Person oldest = astronomers.stream()
                .max(Comparator.comparing(a -> a.getAge()))
                .get();
        System.out.println("Oldest: " + oldest.getFirstName() + " " + oldest.getLastname()
                + " (Age: " + oldest.getAge() + ")");
    }

    public static void printYoungest() {
        Person youngest = astronomers.stream()
                .min(Comparator.comparing(a -> a.getAge()))
                .get();
        System.out.println("Youngest: " + youngest.getFirstName() + " " + youngest.getLastname()
                + " (Age: " + youngest.getAge() + ")");
    }
}