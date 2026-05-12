package com.pluralsight;

public class House extends Asset {
    private String address;
    private int condition, squareFoot, lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    public double getValue() {
        double rate = 0;

        switch(this.condition) {
            case 1: //excellent
                rate = 180;
                break;
            case 2: //good
                rate = 130;
                break;
            case 3: //fair
                rate = 90;
                break;
            case 4: //poor
                rate = 80;
                break;
        }

        double value = (rate * this.squareFoot) + (.25 * this.lotSize);

        return value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
