package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lesson {
    public static void main(String[] args) {
        try {
            //FileReader, reads the file

            //relative pathing - based on where we are
            //absolute pathing - based on full location within computer
            //a path == location
            FileReader fileReader = new FileReader("src/main/resources/poem.txt");
            //BufferedReader, consumes the read file efficiently
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            while((input = bufReader.readLine()) != null) {
                System.out.println(input);
                try {
                    Thread.sleep(1000); //pauses program, for ms time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
