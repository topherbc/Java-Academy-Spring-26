package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("--Welcome to the Mortgage Calculator!--\n");
        System.out.println("--Let's figure out your monthly payment and interest!--\n");
        System.out.print("Please enter the principal: ");
        double p = scan.nextDouble();

        System.out.print("Please enter the interest rate percentage: ");
        double r = scan.nextDouble() / 100; //convert percentage to decimal

        System.out.print("Please enter the loan length (in years): ");
        int loanLength = scan.nextInt();

        double i = r / 12; //interest divided by month

        double n = 12 * loanLength;

        //M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
        double m = p * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1); //monthly payment

        //Total Interest = (M×n)−P
        double totalInterest = (m*n)-p;

        System.out.printf("$%.2f/mo payment with a total interest of $%.2f\n", m, totalInterest);

        //Same as printf above, with use of concatenation
        //System.out.println("$" + Math.round(m) + "/mo payment with a total interest of $" + Math.round(totalInterest));
    }
}
