package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;
//import java.io.FileNotFoundException;
//import java.io.FileReader;

public class PayrollApp {
    public static void main(String[] args) {

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/employees.csv"));

            String input;
            buffReader.readLine(); //.readLine == reads a line
            while((input = buffReader.readLine()) != null) {
                String[] splitData = input.split(Pattern.quote("|"));
                int id = Integer.parseInt(splitData[0]);
                String name = splitData[1];
                double hoursWorked = Double.parseDouble(splitData[2]);
                double payRate = Double.parseDouble(splitData[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                System.out.printf("%d | %s | $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            buffReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
