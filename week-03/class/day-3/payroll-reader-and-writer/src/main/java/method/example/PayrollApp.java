package method.example;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayrollApp {

    public static void main(String[] args) {
        userInputScreen();
    }

    public static void userInputScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine().trim();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine().trim();

        scanner.close();

        Employee[] employees = readEmployees(inputFile);

        int count = countEmployees(employees);

        if (outputFile.endsWith(".json")) {
            writeJson(employees, count, outputFile);
        } else {
            writeCsv(employees, count, outputFile);
        }

        System.out.println("Payroll report written to: " + outputFile);
    }

    public static int countEmployees(Employee[] employees) {
        // count how many employees were actually loaded
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static Employee[] readEmployees(String filename) {
        Employee[] employees = new Employee[1000];
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + filename));
            reader.readLine(); // skip header row

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(Pattern.quote("|"));
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                employees[count] = new Employee(id, name, hoursWorked, payRate);
                count++;
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }

    public static void writeCsv(Employee[] employees, int count, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + filename));
            writer.write("id|name|gross pay");
            writer.newLine();

            for (int i = 0; i < count; i++) {
                Employee e = employees[i];
                writer.write(String.format("%d|%s|%.2f", e.getEmployeeId(), e.getName(), e.getGrossPay()));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    public static void writeJson(Employee[] employees, int count, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + filename));
            writer.write("[");
            writer.newLine();

            for (int i = 0; i < count; i++) {
                Employee e = employees[i];
                String comma = (i < count - 1) ? "," : "";

                writer.write(String.format("  { \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }%s",
                        e.getEmployeeId(), e.getName(), e.getGrossPay(), comma));
                writer.newLine();
            }

            writer.write("]");
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing JSON: " + e.getMessage());
        }
    }
}