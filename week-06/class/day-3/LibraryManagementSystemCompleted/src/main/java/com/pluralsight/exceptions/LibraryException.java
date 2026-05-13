package com.pluralsight.exceptions;

/**
 * Base exception class for all library-related exceptions.
 * Provides a foundation for specific exception types in the library system.
 * All custom exceptions in the library management system extend this class.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class LibraryException extends Exception {
    public LibraryException(String message) {
        super(message);
    }
    
    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}