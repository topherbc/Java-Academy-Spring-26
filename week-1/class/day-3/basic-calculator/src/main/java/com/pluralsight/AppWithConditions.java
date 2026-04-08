package com.pluralsight;

import java.util.Scanner;

public class AppWithConditions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNum = sc.nextInt();
        sc.nextLine();


        System.out.print("Enter the second number: ");
        int secondNum = sc.nextInt();
        sc.nextLine();

        System.out.println("Possible calculations:");
        System.out.println("\t(A)dd");
        System.out.println("\t(S)ubtract");
        System.out.println("\t(M)ultiply");
        System.out.println("\t(D)ivide");
        System.out.print("Please select an option: ");
        String operatorSelection = sc.nextLine().trim();

        int total = 0;
        String operator = "";

        if (operatorSelection.equalsIgnoreCase("A")) {
            total = firstNum + secondNum;
            operator = "+";
        } else if (operatorSelection.equalsIgnoreCase("S")) {
            total = firstNum - secondNum;
            operator = "-";
        } else if (operatorSelection.equalsIgnoreCase("M")) {
            total = firstNum * secondNum;
            operator = "*";
        } else if (operatorSelection.equalsIgnoreCase("D")) {
            total = firstNum / secondNum;
            operator = "/";
        } else {
            System.out.println("Incorrect option selected, defaulting to multiplication.");
            total = firstNum * secondNum;
            operator = "*";
        }

        System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, total);
    }
}
