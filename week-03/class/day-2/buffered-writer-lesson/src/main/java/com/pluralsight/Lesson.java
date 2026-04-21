package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson {
    public static void main(String[] args) {
        try {

            FileWriter fileWriter = new FileWriter("src/main/resources/counter.txt", true);

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            for (int i = 20; i <= 30 ; i += 2) {
                bufWriter.write("Counting " + i);
                bufWriter.newLine();
            }

            bufWriter.close(); //saving the file

        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }
    }
}
