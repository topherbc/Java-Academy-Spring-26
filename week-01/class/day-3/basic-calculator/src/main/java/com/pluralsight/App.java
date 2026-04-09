package com.pluralsight;

import java.util.Scanner;

public class App {
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
        String operator = sc.nextLine();

        int total = firstNum*secondNum;

//        System.out.println(firstNum + " * " + secondNum + " = " + total);
        System.out.printf("%d * %d = %d", firstNum, secondNum, total);


    }
}
