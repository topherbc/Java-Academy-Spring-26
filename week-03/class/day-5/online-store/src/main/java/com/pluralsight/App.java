package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
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
        ArrayList<Product> cart = new ArrayList<>();

        while (true) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) Display Products");
            System.out.println("\t2) Display Cart");
            System.out.println("\t0) Exit");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            switch (userOption) {
                case 1:
                    cart = productsScreen(scanner, cart);
                    break;
                case 2:
                    cart = displayCartScreen(cart, scanner);
                    break;
                case 0:
                    System.out.println("\n\uD83D\uDE03 Thanks for visiting my online store!!!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    waitAndContinue(scanner, "Incorrect Option Entered ");
            }
        }
    }

    public static ArrayList<Product> productsScreen(Scanner scanner, ArrayList<Product> cart) {
        HashMap<String, Product> products = loadInventory();

        formatSpaces(); //user screen formatting

        boolean run = true;
        while (run) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) View All Products");
            System.out.println("\t2) Search Products");
            System.out.println("\t3) Add Product to Cart");
            System.out.println("\t4) Add New Product");
            System.out.println("\t0) Go Back to Home Screen");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            formatSpaces(); //user screen formatting

            switch (userOption) {
                case 1:
                    displayProducts(scanner, products);
                    break;
                case 2:
                    searchProductsScreen(scanner, products);
                    break;
                case 3:
                    cart = addProductToCart(scanner, products, cart);
                    break;
                case 4:
                    addProduct(scanner, products);
                    products = loadInventory();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    waitAndContinue(scanner, "Incorrect Option Entered ");
            }
        }

        return cart;
    }

    public static void searchProductsScreen(Scanner scanner, HashMap<String, Product> products) {
        formatSpaces(); //user screen formatting

        System.out.println("Searching Products...");

        boolean run = true;
        while(run) {
            System.out.println("Select from the following search options: ");
            System.out.println("\t1) Product Name");
            System.out.println("\t2) SKU");
            System.out.println("\t3) Price Range");
            System.out.println("\t4) Department");
            System.out.println("\t0) Go Back to Products Screen");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            formatSpaces();

            switch(userOption) {
                case 1:
                    searchProductsString("Product Name", products, scanner);
                    break;
                case 2:
                    searchProductsString("SKU", products, scanner);
                    break;
                case 3:
                    searchProductsPriceRange(products, scanner);
                    break;
                case 4:
                    searchProductsString("Department", products, scanner);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    waitAndContinue(scanner, "Incorrect Option Entered ");
            }

        }
    }

    public static ArrayList<Product> displayCartScreen(ArrayList<Product> cart, Scanner scanner) {

        System.out.println("Viewing Cart Menu");

        boolean run = true;
        while(run) {
            System.out.println("Select from the following options: ");
            System.out.println("\t1) View Cart");
            System.out.println("\t2) Checkout");
            System.out.println("\t3) Clear Cart");
            System.out.println("\t4) Remove Item From Cart");
            System.out.println("\t0) Go Back to Home Screen");
            System.out.print("Enter your selection: ");
            int userOption = scanner.nextInt();
            scanner.nextLine(); //handles that newline / crlf

            formatSpaces();

            switch(userOption) {
                case 1:
                    for (Product p : cart) {
                        formatProductPrint(p);
                    }

                    waitAndContinue(scanner, "\nFinished Viewing: ");
                    break;
                case 2:
                    //checkout(cart)
                    break;
                case 3:
                    cart = clearCart(cart);
                    break;
                case 4:
                    cart = removeItemFromCart(scanner, cart);
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    waitAndContinue(scanner, "Incorrect Option Entered ");
            }

        }
        return cart;
    }

    public static ArrayList<Product> removeItemFromCart(Scanner scanner, ArrayList<Product> cart) {
        System.out.print("Remove cart item by SKU: ");
        String sku = scanner.nextLine().trim();

        int removeProductIndex = -1;

        for (Product p : cart) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                removeProductIndex = cart.indexOf(p);
            }
        }

        if (removeProductIndex != -1) {
            cart.remove(removeProductIndex);
        }

        return cart;
    }

    public static ArrayList<Product> addProductToCart(Scanner scanner, HashMap<String, Product> products, ArrayList<Product> cart) {
        System.out.print("Add product by SKU: ");
        String sku = scanner.nextLine().trim();

        cart.add(products.get(sku));
        return cart;
    }

    public static void searchProductsPriceRange(HashMap<String, Product> products, Scanner scanner) {
        System.out.print("Enter the minimum price: ");
        int minPrice = scanner.nextInt();
        scanner.nextLine(); //consume newline

        System.out.print("Enter the maximum price: ");
        int maxPrice = scanner.nextInt();
        scanner.nextLine(); //consume newline

        formatSpaces(); //user screen formatting

        for (Product p : products.values()) {
            if (p.getPrice() > minPrice && p.getPrice() < maxPrice) {
                formatProductPrint(p);
            }
        }

        waitAndContinue(scanner, "\nFinished Viewing: ");
    }

    public static void searchProductsString(String searchTerm, HashMap<String, Product> products, Scanner scanner) {
        System.out.print("Enter " + searchTerm + ": ");
        String searchValue = scanner.nextLine().trim().toLowerCase();

        formatSpaces(); //user screen formatting

        for (Product p : products.values()) {
            if (
                    p.getProductName().toLowerCase().contains(searchValue)
                    || p.getDepartment().toLowerCase().contains(searchValue)
                    || p.getSku().toLowerCase().contains(searchValue)
            ) {
                formatProductPrint(p);
            }

        }

        waitAndContinue(scanner, "\nFinished Viewing: ");
    }

    public static void displayProducts(Scanner scanner, HashMap<String, Product> products) {
        for (Product p : products.values()) {
            formatProductPrint(p);
        }

        waitAndContinue(scanner, "\nFinished Viewing: ");
    }

    public static HashMap<String, Product> loadInventory() {
        HashMap<String, Product> products = new HashMap<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));

            String productItem;
            buffReader.readLine(); //deals with header row
            while ((productItem = buffReader.readLine()) != null) {
                String[] splitProductItem = productItem.split(Pattern.quote("|"));

                String sku = splitProductItem[0].trim();
                String productName = splitProductItem[1].trim();
                double price = Double.parseDouble(splitProductItem[2]);
                String department = splitProductItem[3].trim();

                Product product = new Product(sku, productName, department, price);
                products.put(sku, product);
            }

            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void addProduct(Scanner scanner, HashMap<String, Product> products) {
        System.out.println("Welcome to the Add Product Editor!\n");
        System.out.println("Create the new product below: ");
        System.out.print("Enter the Product's SKU: ");
        String sku = scanner.nextLine().trim();

        System.out.print("Enter the Product's Name: ");
        String productName = scanner.nextLine().trim();

        System.out.print("Enter the Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); //consume newline

        System.out.print("Enter the Product's Department: ");
        String department = scanner.nextLine().trim();

        Product newProduct = new Product(sku, productName, department, price);

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("src/main/resources/products.csv"));

            buffWriter.write("SKU|Product Name|Price|Department");
            buffWriter.newLine();

            for (Product p : products.values()) {
                buffWriter.write(csvFormat(p));
                buffWriter.newLine();
            }

            buffWriter.write(csvFormat(newProduct));
            buffWriter.newLine();

            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> clearCart(ArrayList<Product> cart) {
        cart.clear();
        return cart;
    }

    public static String csvFormat(Product p) {
        return String.format("%s|%s|%.2f|%s", p.getSku(), p.getProductName(), p.getPrice(), p.getDepartment());
    }

    public static void formatProductPrint(Product p) {
        System.out.printf("Product Name: %s - Price: $%.2f - Department: %s%n", p.getProductName(), p.getPrice(), p.getDepartment());
    }

    public static void waitAndContinue(Scanner scanner, String message) {
        System.out.println(message + "(press ENTER to continue)");
        scanner.nextLine();
        formatSpaces();
    }

    public static void formatSpaces() {
        System.out.println("\n\n\n\n");
    }
}
