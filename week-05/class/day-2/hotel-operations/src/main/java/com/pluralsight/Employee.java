package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name, department;
    private double payRate, hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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
}
