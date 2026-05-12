package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year, odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int age = LocalDate.now().getYear() - this.year;

        double value = this.originalCost;

        if (age <= 3) {
            value *= Math.pow(0.97, age);
        } else if (age <= 6) {
            value *= Math.pow(0.94, age);
        } else if (age <= 10) {
            value *= Math.pow(0.92, age);
        } else {
            value = 1000;
        }

        if (this.odometer > 100000 && !(this.makeModel.contains("Honda") || this.makeModel.contains("Toyota"))) {
            value *= 0.75;
        }

        return value;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
