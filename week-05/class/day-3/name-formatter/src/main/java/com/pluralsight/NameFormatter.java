package com.pluralsight;

public class NameFormatter {
//    LastName, Prefix FirstName MiddleName, Suffix
//    Johnson, Dr. Mel B, PhD
//    Johnson, Mel B, PhD
//    Johnson, Me
    public static String format(String firstName,
                                String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        return String.format("%s, %s %s %s, %s", lastName, prefix, firstName, middleName, suffix);
    }

    public static String format(String fullName) {
        String[] fullNameSplit = fullName.split("\\ ");

        if (fullNameSplit.length == 2) {
            return format(fullNameSplit[0], fullNameSplit[1]);
        } else if (fullNameSplit.length == 4) {
            return format(null, fullNameSplit[0], fullNameSplit[1], fullNameSplit[2], fullNameSplit[3]);
        } else if (fullNameSplit.length == 5) {
            return format(fullNameSplit[0], fullNameSplit[1], fullNameSplit[2], fullNameSplit[3], fullNameSplit[4]);
        }

        return "Incorrect name format"; //Output format: LastName, Prefix FirstName MiddleName, Suffix
    }
}
