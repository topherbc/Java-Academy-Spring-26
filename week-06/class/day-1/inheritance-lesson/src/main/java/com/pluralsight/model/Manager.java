package com.pluralsight.model;

public class Manager extends Employee {
    private int teamSize;

    @Override
    public void work() {
        System.out.println("Manager " + this.id + " is managing a team of " + this.teamSize + " employees");
    }

    public void seePrivateData() {
        System.out.println(this.ssn);
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
