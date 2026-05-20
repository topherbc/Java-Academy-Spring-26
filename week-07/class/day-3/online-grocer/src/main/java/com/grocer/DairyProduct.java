package com.grocer;

public class DairyProduct {
    private String id;
    private String name;
    private double price;
    private String category;
    private int stockQuantity;
    private double fatContent;
    private boolean organic;

    // Constructor
    public DairyProduct(String id, String name, double price, String category,
                        int stockQuantity, double fatContent, boolean organic) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.fatContent = fatContent;
        this.organic = organic;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public double getFatContent() { return fatContent; }
    public void setFatContent(double fatContent) { this.fatContent = fatContent; }

    public boolean isOrganic() { return organic; }
    public void setOrganic(boolean organic) { this.organic = organic; }

    @Override
    public String toString() {
        return String.format("%-6s | %-20s | $%.2f | %-20s | Stock: %-3d | Fat: %.1f%% | %s",
                id,
                name,
                price,
                category,
                stockQuantity,
                fatContent,
                organic ? "Organic" : "Conventional");
    }
}
