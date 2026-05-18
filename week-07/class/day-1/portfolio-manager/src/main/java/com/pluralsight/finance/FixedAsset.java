package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable{
    protected String name;
    protected int marketValue;

    public FixedAsset(String name, int marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public FixedAsset() {

    }

    @Override
    public double getValue() {
        return this.marketValue;
    }
}
