package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ConversionLesson {
    public static void main(String[] args) {

        String input = "94011|Organic Bananas|3|2.50";

        String[] splitInput = input.split(Pattern.quote("|"));

        int id = Integer.parseInt(splitInput[0]);
        String name = splitInput[1];
        int quantity = Integer.parseInt(splitInput[2]);
        double price = Double.parseDouble(splitInput[3]);

        String date = "04/14/2026";
        String otherDate = "2026-04-14";
        //YYYY-MM-DD
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate today = LocalDate.parse(date, format);

        System.out.println(today.datesUntil(LocalDate.parse("2027-04-14")).count());




    }
}
