package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(String name, int marketValue, double weight) {
        super(name, marketValue);
        this.weight = weight;
    }

    public Gold() {
        super();
    }

    @Override
    public double getValue() {
        return this.weight * this.marketValue;
    }
}
