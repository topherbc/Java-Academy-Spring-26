package com.pluralsight.model;

public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println("Manager " + this.name + " is managing a team of " + this.teamSize + " employees");
    }


    public void doManagement() {
        System.out.println(this.name + " is managing");
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
