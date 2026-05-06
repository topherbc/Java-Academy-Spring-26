package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);

    public static final double discount = 1.10;

    public static void main(String[] args) {

        //final = sets variable to final value
        //final == constant, something unchanging
        //immutable == not mutatable == non modifiable

//        StringUtilsMaker sum = new StringUtilsMaker();
//        sum.greet("Felicia"); //using non-static (instance) object and method

        Math.round(Math.PI); //Using static method and static property

        System.out.println(StringUtils.greet("Felicia")); // using static class

//        test(); //example of use of static property
    }

    public static void test() {
        scan.nextLine();
    }
}
