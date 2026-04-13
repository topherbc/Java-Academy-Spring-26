package com.pluralsight;

import java.util.regex.Pattern;

public class StringMethodsLesson {
    public static void main(String[] args) {


        String phoneNumber = "(808) 111-2323";
        String phoneNumber2 = "8885552322";

        //does this number, contain just numbers
        // or does it contain symbols and numbers?

//        String.contains("value") -- Returns true or false if value is within string
        //String.length() - returns count of characters
        //String.equals() - are the strings the same?
        //String.equalsIgnoreCase() - compare strings
//        System.out.println(phoneNumber2.length());


        if (phoneNumber.equals(phoneNumber2)) {
//            System.out.println("Theyre the same");
        } else {
//            System.out.println("Theyre not the same");
        }

        String discountCode = "     SAVE-50-LOSE    54545545454";
//        System.out.println(discountCode);
//        System.out.println(discountCode.trim());
        //String.trim() - removes whitespace from either side of string

//        discountCode.trim().equalsIgnoreCase("SAVE-50-LOSE");


        String name = "Example Name";

        //String.toUpperCase() - convert to all upper case characters
        //String.toLowerCase() - convert to all lower case characters
        //String.charAt() - returns character at position
        //String.startsWith() - returns boolean if string starts with string
        //String.endsWith() - returns boolean if string ends with string

//        System.out.println(name.startsWith("Example"));

        //delimiter - symbol that separates
        String cities = "Pittsburgh|Philadelphia|tlanta|Chicago|Miami|Nashville";

        //Two ways to pass to split
        // either \\delimiter or Pattern.quote(delimeter)
//        String[] parsedCities = cities.split("\\|");
        String[] parsedCities = cities.split(Pattern.quote("|"));

        System.out.println(parsedCities[2]);



    }
}
