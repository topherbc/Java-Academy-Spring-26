package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the deposit amount: ");
        double deposit = sc.nextDouble();

        System.out.print("Enter the interest rate: ");
        double interestRate = sc.nextDouble();

        System.out.print("The total years the deposit will earn interest: ");
        int numOfYears = sc.nextInt();

        double futureValue = deposit * (1 + Math.pow(interestRate / 365, (365 * numOfYears)));
        double totalInterestEarned = futureValue - deposit;

        System.out.printf("After deposit, your future value will be $%.2f", futureValue);
        System.out.printf("and your total interest rate will be $%.2f", totalInterestEarned);
    }
}
