package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {

//        1. Create two variables to represent the salary for Bob and Gary, name them
//        bobSalary and garySalary. Create a new variable named
//        highestSalary. Determine whose salary is greater using Math.max() and
//        store the answer in highestSalary. Set the initial salary variables to any value
//        you want. Print the answer (i.e "The highest salary is …")

        int bobSalary = 8000000;
        int garySalary = 950000;
        int highestSalary = Math.max(bobSalary, garySalary);

        System.out.println("Highest salary: $" + highestSalary);



//        2. Find and display the smallest of two variables named carPrice and
//        truckPrice. Set the variables to any value you want.

        int carPrice = 10000;
        int truckPrice = 15000;
        int cheapestVehiclePrice = Math.min(carPrice, truckPrice);
        System.out.println("Cheapest Vehicle Price is: $" + cheapestVehiclePrice);


//        3. Find and display the area of a circle whose radius is 7.25

        double radius = 7.25;
        System.out.println("The area is " + Math.PI * Math.pow(radius, 2));


//        4. Find and display the square root a variable after it is set to 5.0

        double number = 5.0;
        System.out.println("Square root of 5.0: " + Math.sqrt(number));


//        5. Find and display the distance between the points (5, 10) and (85, 50)
        int a = 5;
        int b = 10;
        int p = 85;
        int q = 50;
        double distance = Math.hypot(a-p, b-q);
        System.out.println("Distance between two points: " + distance);


//        6. Find and display the absolute (positive) value of a variable after it is set to -3.8

        double absoluteValue = Math.abs(-3.8);
        System.out.println("Absolute Value of -3.8: " + absoluteValue);


//        7. Find and display a random number between 0 and 1
        double aRandomNumber = Math.random();
        System.out.println("A random number: " + aRandomNumber);

        // 7. Find and display a random number between 1 and 20

        int between1And20 = (int)(Math.random() *  20 - 1 + 1) + 1;
        System.out.println("A random number between 1 and 20: " + between1And20);

    }
}
