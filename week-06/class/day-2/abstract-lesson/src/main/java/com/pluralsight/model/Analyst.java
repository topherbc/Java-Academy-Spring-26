package com.pluralsight.model;

public class Analyst extends Employee {

    public Analyst(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("Analyst doing work, whatever that is");
    }
}
