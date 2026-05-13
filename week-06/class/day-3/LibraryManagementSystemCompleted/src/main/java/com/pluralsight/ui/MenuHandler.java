package com.pluralsight.ui;

import java.util.Scanner;
import com.pluralsight.exceptions.LibraryException;
import com.pluralsight.service.Logger;

/**
 * Abstract base class for all menu handlers in the library system.
 * Provides common functionality such as input processing and displaying messages.
 * Concrete implementations include MainMenu, BookMenu, MovieMenu, and MagazineMenu.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public abstract class MenuHandler {
    protected Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Gets a menu choice from the user
     * @return The user's choice as an integer, or -1 if input was invalid
     */
    protected int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            Logger.getInstance().debug("Invalid number format for menu choice", e);
            return -1;
        }
    }

    protected void displayInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }
    
    /**
     * Standard error handling for library operations
     * 
     * @param e The exception that occurred
     * @param operation The operation that failed (e.g., "borrow book", "add member")
     * @param context Additional context information (optional)
     */
    protected void handleLibraryException(Exception e, String operation, String context) {
        if (e instanceof LibraryException) {
            String errorMessage = com.pluralsight.exceptions.ExceptionHandler.handleException(
                (LibraryException)e, operation, context);
            System.out.println("Error: " + errorMessage);
        } else {
            String errorMessage = com.pluralsight.exceptions.ExceptionHandler.handleGenericException(e, operation);
            System.out.println("Error: " + errorMessage);
        }
    }
}