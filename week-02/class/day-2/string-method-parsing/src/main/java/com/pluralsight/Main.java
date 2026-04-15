package com.pluralsight;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "121|Hot Chocolate (12-count)|2|4.99|2026-04-14";
        String[] splitInput = input.split(Pattern.quote("|"));

        int id = Integer.parseInt(splitInput[0]);
        String name = splitInput[1];
        int quantity = Integer.parseInt(splitInput[2]);
        double price = Double.parseDouble(splitInput[3]);

        LocalDate today = LocalDate.parse(splitInput[4]);

        System.out.println(today);
    }
}
