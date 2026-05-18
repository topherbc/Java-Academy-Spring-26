package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private double karat;

    public Jewelry(String name, int marketValue, double karat) {
        super(name, marketValue);
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return this.marketValue * (this.karat / 14);
    }
}
