package com.grocer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchUtilities {
    /**
     * Filters the product list to return only products from the specified category.
     *
     * @param category The product category to filter by (e.g., "Milk", "Cheese")
     * @param products The list of dairy products to filter
     * @return A new ArrayList containing only the products from the specified category
     */
    public static List<DairyProduct> getByProductCategory(String category, ArrayList<DairyProduct> products) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();

        
//        ArrayList<DairyProduct> matches = new ArrayList<>();
//
//        for (DairyProduct dairyProduct : products) {
//            if (category.equalsIgnoreCase(dairyProduct.getCategory())) {
//                matches.add(dairyProduct);
//            }
//        }
//
//        return matches;
    }

    /**
     * Filters the product list to return only the total product value for products from the specified category.
     * The value is calculated as the sum of (price × stockQuantity) for each product.
     *
     * @param category The product category to filter by (e.g., "Milk", "Cheese")
     * @param products The list of dairy products to filter
     * @return The total monetary value of all products in the inventory from the specified category
     */
    public static double getByCategoryTotalProductValue(String category, ArrayList<DairyProduct> products) {
        return products.stream()
                .filter((dairyProduct -> {
                    return dairyProduct.getCategory().equals(category);
                }))
                .mapToDouble((dairyProduct) -> dairyProduct.getPrice() * dairyProduct.getStockQuantity())
                .sum();


//        double sum = 0;
//
//        for (DairyProduct dairyProduct : products) {
//            if (category.equals(dairyProduct.getCategory())) {
//                sum += dairyProduct.getPrice() * dairyProduct.getStockQuantity();
//            }
//        }
//
//        return sum;
    }

    /**
     * Calculates the total value of all products in inventory.
     * The value is calculated as the sum of (price × stockQuantity) for each product.
     *
     * @param products The list of dairy products to calculate total value for
     * @return The total monetary value of all products in the inventory
     */
    public static double getTotalProductValue(ArrayList<DairyProduct> products) {
        // int t = (int) products.stream().mapToInt(DairyProduct::getStockQuantity).average().getAsDouble();


//        return products.stream().mapToDouble(p -> p.getPrice() * p.getStockQuantity()).sum();


        double sum = 0;

        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice() * products.get(i).getStockQuantity();
        }

        return sum;
    }

    /**
     * Counts the total number of products in the inventory.
     *
     * @param products The list of dairy products to count
     * @return The total count of products in the list
     */
    public static int getTotalProductCount(ArrayList<?> products) {
        return (int) products.stream().count();


//        return products.size();
    }

    /**
     * Counts the number of organic products in the inventory.
     * Organic products are those where the 'organic' field is true.
     *
     * @param products The list of dairy products to filter and count
     * @return The count of organic products in the list
     */
    public static int getTotalOrganicProductCount(ArrayList<DairyProduct> products) {
        return (int) products.stream().filter(DairyProduct::isOrganic).count();


//        int count = 0;
//
//        for (DairyProduct dairyProduct : products) {
//            if (dairyProduct.isOrganic()) {
//                count++;
//            }
//        }
//
//        return count;
    }
}
