package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class DealershipFileManager {
    public static Dealership getDealership() {
        Dealership dealership = new Dealership("Super Cool Car Imports", "111 Old Benbrook Rd", "817-555-5555");

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            String vehicleData;
            buffReader.readLine(); //deals with header row
            while ((vehicleData = buffReader.readLine()) != null) {
                String[] splitVehicles = vehicleData.split(Pattern.quote("|"));

                int vin = Integer.parseInt(splitVehicles[0]);
                int year = Integer.parseInt(splitVehicles[1]);
                String make = splitVehicles[2];
                String model = splitVehicles[3];
                String vehicleType = splitVehicles[4];
                String color = splitVehicles[5];
                int odometer = Integer.parseInt(splitVehicles[6]);
                double price = Double.parseDouble(splitVehicles[7]);

                Vehicle vehicle = new Vehicle(vin, year, odometer, make, model, vehicleType, color, price);
                dealership.addVehicle(vehicle);
            }

            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

    }
}
