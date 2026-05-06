package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private int employeeId, startTime;
    private String name, department;
    private double payRate, hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = -1;
    }

    public int getStartTime() {
        return startTime;
    }

    public double getTotalPay() {
        return (this.payRate * this.getRegularHours()) + (this.getOvertimeHours() * (this.payRate * 1.5));
    }

    public double getRegularHours() {
        if (this.hoursWorked > 40) {
            return 40;
        }
        return this.hoursWorked;
    }

    public double getOvertimeHours() {
        if (this.hoursWorked > 40) {
            return this.hoursWorked-40;
        } else {
            return 0;
        }
    }

    public void punchIn(int time) {
        this.startTime = time;
    }

    public void punchIn() {
        this.startTime = LocalTime.now().getHour();
    }

    public void punchOut(int time) {
        this.hoursWorked += time-startTime;
    }

    public void punchOut() {
        int time = LocalTime.now().getHour();
        this.hoursWorked += time-startTime;
    }

    public void punchTimeCard(int time) {
       if (this.startTime == -1) {
           this.startTime = time;
       } else {
           this.hoursWorked += time-startTime;
           this.startTime = -1;
       }
    }

    public void punchTimeCard() {
        int time = LocalTime.now().getHour();
        if (this.startTime == -1) {
            this.startTime = time;
        } else {
            this.hoursWorked += time-startTime;
            this.startTime = -1;
        }
    }
}
