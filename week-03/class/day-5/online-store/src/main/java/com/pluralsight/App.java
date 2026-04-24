package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the online store!");

        homeScreen(scanner);
    }

    public static void homeScreen(Scanner scanner) {
        while(true) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) Display Products");
            System.out.println("\t2) Display Cart");
            System.out.println("\t0) Exit");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            switch (userOption) {
                case 1:
                    displayProducts(scanner);
                    formatSpaces();
                    break;
                case 2:
//                displayCart(scanner);
                    formatSpaces();
                    break;
                case 0:
                    System.out.println("\n\uD83D\uDE03 Thanks for visiting my online store!!!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option entered (press ENTER to continue)");
                    scanner.nextLine();
                    formatSpaces();
            }
        }
    }

    public static void displayProducts(Scanner scanner) {
        HashMap<String, Product> products = loadInventory();

        boolean run = true;
        while(run) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) View All Products");
            System.out.println("\t2) Search Products");
            System.out.println("\t3) Add Product");
            System.out.println("\t0) Go Back");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            switch (userOption) {
                case 1:
                    for (Product p : products.values()) {
                        System.out.printf("%s: $%.2f%n", p.getProductName(), p.getPrice());
                    }
                    formatSpaces();
                    break;
                case 2:
                    //searchProducts()
                    break;
                case 3:
                    //addProducts()
                    break;
                case 0:
                    formatSpaces();
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect option entered (press ENTER to continue)");
                    scanner.nextLine();
                    formatSpaces();
            }
        }
    }

    public static HashMap<String, Product> loadInventory() {
        HashMap<String, Product> products = new HashMap<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));

            String productItem;
            buffReader.readLine(); //deals with header row
            while((productItem = buffReader.readLine()) != null) {
                String[] splitProductItem = productItem.split(Pattern.quote("|"));

                String sku = splitProductItem[0];
                String productName = splitProductItem[1];
                double price = Double.parseDouble(splitProductItem[2]);
                String department = splitProductItem[3];

                Product product = new Product(sku, productName, department, price);
                products.put(sku, product);
            }

            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void formatSpaces() {
        System.out.println("\n\n");
    }

}
