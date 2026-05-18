package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt, squareFeet, bedrooms;

    public House(String name, int marketValue, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        return this.marketValue;
    }
}
