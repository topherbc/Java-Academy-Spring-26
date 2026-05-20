package com.grocer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DairyProductDataManager {
    private final String csvFilePath;

    public DairyProductDataManager() {
        this.csvFilePath = "src/main/resources/dairy.csv";
    }

    public ArrayList<DairyProduct> loadDairyProducts() {
        ArrayList<DairyProduct> dairyProducts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                DairyProduct product = parseProductFromCSV(line);
                if (product != null) {
                    dairyProducts.add(product);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return dairyProducts;
    }

    private DairyProduct parseProductFromCSV(String line) {
        try {
            String[] values = line.split(",");

            String id = values[0];
            String name = values[1];
            double price = Double.parseDouble(values[2]);
            String category = values[3];
            int stockQuantity = Integer.parseInt(values[4]);
            double fatContent = Double.parseDouble(values[5]);
            boolean organic = Boolean.parseBoolean(values[6]);

            return new DairyProduct(id, name, price, category, stockQuantity, fatContent, organic);
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line + " - " + e.getMessage());
            return null;
        }
    }
}
