package com.pluralsight.model;

public class Employee {
    protected String name;
    protected int id;
    protected double salary;
    protected String ssn;

    public void work() {
        System.out.println("Employee " + this.name + " is working");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
