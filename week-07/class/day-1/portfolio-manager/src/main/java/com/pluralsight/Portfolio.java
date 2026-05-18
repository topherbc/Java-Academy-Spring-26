package com.pluralsight;

import com.pluralsight.finance.Gold;
import com.pluralsight.finance.Valuable;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name, owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public void add(Valuable asset) {
        this.assets.add(asset);
    }

    public double getValue() {
        double value = 0;
        for (Valuable v:this.assets) {
            value += v.getValue();
        }
        return value;
    }

    public Valuable getMostValuable() {
        Valuable mostValuable = new Gold();
        double highestValue = 0;
        for (Valuable v:this.assets) {
            if (v.getValue() > highestValue) {
                highestValue = v.getValue();
                mostValuable = v;
            }
        }
        return mostValuable;
    }
    public Valuable getLeastValuable() {
        Valuable leastValuable = new Gold();
        double leastValue = 999999999;
        for (Valuable v:this.assets) {
            if (v.getValue() < leastValue) {
                leastValue = v.getValue();
                leastValuable = v;
            }
        }
        return leastValuable;
    }
}
