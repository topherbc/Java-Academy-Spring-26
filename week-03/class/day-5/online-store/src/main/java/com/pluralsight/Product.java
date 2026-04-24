package com.pluralsight;

public class Product {
    private String sku, productName, department;
    private double price;

    public Product(String sku, String productName, String department, double price) {
        this.sku = sku;
        this.productName = productName;
        this.department = department;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public String getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }
}
