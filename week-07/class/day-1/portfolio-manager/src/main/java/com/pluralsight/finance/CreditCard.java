package com.pluralsight.finance;

public class CreditCard implements Valuable {
    private String name, accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void pay(double amount) {
        this.balance += amount;
    }

    public void charge(double amount) {
        this.balance -= amount;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
