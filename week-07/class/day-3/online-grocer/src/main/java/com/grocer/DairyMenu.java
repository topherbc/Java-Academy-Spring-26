package com.grocer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DairyMenu {

    public static DairyProductDataManager dairyDataManager = new DairyProductDataManager();

    public static ArrayList<DairyProduct> dairyProducts = dairyDataManager.loadDairyProducts();

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("---Welcome to the Dairy section---");
        System.out.println("\n---\n");
        System.out.println("---Our specials today are on: Cheese!---");
        System.out.println("\n");

        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Search by product category");
            System.out.println("2. Calculate total value of all products");
            System.out.println("3. Get total count of products");
            System.out.println("4. Get count of organic products");
            System.out.println("5. View all products");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.println("--- Search by Category ---");
                    System.out.print("Enter category (Milk, Cheese, Yogurt, Butter, Cream, Non-Dairy Alternative): ");
                    String category = scanner.nextLine().trim();
                    System.out.println("Searching for products in category: " + category);
                    view(SearchUtilities.getByProductCategory(category, dairyProducts));
                    break;

                case "2":
                    System.out.println("--- Total Value of All Products ---");
                    System.out.printf("$%.2f", SearchUtilities.getTotalProductValue(dairyProducts));
                    break;

                case "3":
                    System.out.println("--- Total Count of Products ---");
                    System.out.println(SearchUtilities.getTotalProductCount(dairyProducts));
                    break;

                case "4":
                    System.out.println("--- Count of Organic Products ---");
                    System.out.println(SearchUtilities.getTotalOrganicProductCount(dairyProducts));
                    break;

                case "5":
                    System.out.println("--- All Products ---");
                    view(dairyProducts);
                    break;

                case "0":
                    System.out.println("Thank you for shopping in our Dairy section!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                System.out.println("\n");

            }
        }

        scanner.close();
    }

    public static void view(List<?> list) {
        for (Object items : list) {
            System.out.println(items);
        }
    }
}
