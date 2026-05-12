package com.pluralsight;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("trailer", "2022", 30000, "1234 Trailer st.", 3, 300, 435600));
        assets.add(new House("duplex", "2010", 100000, "1 Last st.", 2, 1250, 43560));

        assets.add(new Vehicle("sports car", "1999", 7000, "Mazda Miata", 1995, 1000));
        assets.add(new Vehicle("lemon", "2025", 15000, "Honda Civic", 2006, 30000));

        for (Asset a: assets) {
            System.out.println(a.getClass().getSimpleName());
            System.out.println("Description: " + a.getDescription());
            System.out.println("Original Cost: " + a.getOriginalCost());
            System.out.println("Date Acquried: " + a.getDateAcquired());
            System.out.println("Current Value: " + a.getValue());
            System.out.println("\n\n");
        }
    }
}
