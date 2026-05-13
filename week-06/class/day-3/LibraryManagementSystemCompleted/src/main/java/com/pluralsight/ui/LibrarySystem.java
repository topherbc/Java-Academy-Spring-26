package com.pluralsight.ui;

import com.pluralsight.service.Library;
import com.pluralsight.service.Logger;
import com.pluralsight.service.observer.ConsoleObserver;
import com.pluralsight.ui.menus.MainMenu;
import com.pluralsight.exceptions.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main entry point for the Library Management System application.
 * Handles system initialization, menu navigation, and data persistence.
 * Uses a singleton instance of the Library service and sets up the console observer.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class LibrarySystem {
    private Library library;
    private Scanner scanner;
    private Logger logger;
    private MainMenu mainMenu;

    public LibrarySystem() {
        this.library = Library.getInstance();
        this.scanner = new Scanner(System.in);
        this.logger = Logger.getInstance();
        this.mainMenu = new MainMenu(scanner, library);

        // Add console observer for notifications
        this.library.addObserver(new ConsoleObserver());
    }

    public void start() {
        logger.info("Library Management System started");
        System.out.println("=== Welcome to Library Management System ===");

        loadData();

        boolean running = true;
        while (running) {
            mainMenu.display();
            int choice = mainMenu.getChoice();
            running = mainMenu.handleChoice(choice);
            System.out.println();
        }

        saveAndExit();
    }

    private void loadData() {
        try {
            library.loadFromCSV();
            System.out.println("Library data loaded successfully.");
            System.out.println("Items loaded: " + library.getAllItems().size());
        } catch (IOException e) {
            logger.error("Failed to load library data", e);
            System.out.println("Warning: Could not load library data. Starting with empty library.");
            System.out.println("Make sure the data/ directory exists with items.csv, members.csv, and borrowed.csv files.");
        }
    }

    private void saveAndExit() {
        logger.info("User initiated save and exit");
        try {
            library.saveToCSV();
            System.out.println("Data saved successfully. Goodbye!");
            logger.info("Library Management System shut down successfully");
        } catch (IOException e) {
            logger.error("Failed to save data during exit", e);
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}