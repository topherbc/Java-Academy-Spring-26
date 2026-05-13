package com.pluralsight.exceptions;

import com.pluralsight.service.Logger;

/**
 * Centralized exception handling for the Library Management System.
 * Provides consistent formatting and logging of exceptions across the application.
 * Creates user-friendly error messages with error codes for easier troubleshooting.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class ExceptionHandler {
    private static final Logger logger = Logger.getInstance();

    /**
     * Handles a library exception and produces a consistent error message
     *
     * @param exception The library exception that occurred
     * @param operation Description of the operation that failed (e.g., "borrow book", "add member")
     * @param context Additional context information (e.g., "Member: M1001, Book: 12345")
     * @return A user-friendly error message
     */
    public static String handleException(LibraryException exception, String operation, String context) {
        String errorCode = generateErrorCode(exception, operation);
        String message = exception.getMessage();
        
        // Enhanced logging with operation context and error code
        if (context != null && !context.isEmpty()) {
            logger.error(String.format("[%s] %s failed: %s (Context: %s)", 
                errorCode, operation, message, context));
        } else {
            logger.error(String.format("[%s] %s failed: %s", errorCode, operation, message));
        }
        
        // Track the full exception stack trace for debugging
        logger.debug("Exception details", exception);
        
        // Return user-friendly message
        return formatUserMessage(exception, errorCode);
    }
    
    /**
     * Handles a generic exception (non-LibraryException)
     *
     * @param exception The exception that occurred
     * @param operation Description of the operation that failed
     * @return A user-friendly error message
     */
    public static String handleGenericException(Exception exception, String operation) {
        String errorCode = "ERR-" + System.currentTimeMillis() % 10000;
        
        logger.error(String.format("[%s] Unexpected error in %s: %s", 
            errorCode, operation, exception.getMessage()));
        logger.debug("Exception details", exception);
        
        return "An unexpected error occurred. Please try again later. (Error code: " + errorCode + ")";
    }
    
    /**
     * Generates a unique error code based on the exception type and operation
     */
    private static String generateErrorCode(LibraryException exception, String operation) {
        String exceptionType = exception.getClass().getSimpleName()
            .replace("Exception", "")
            .replace("Library", "");
            
        // Format: First 3 chars of operation + first 3 chars of exception type + timestamp
        String opCode = operation.replaceAll("\\s+", "").substring(0, Math.min(3, operation.length())).toUpperCase();
        String exCode = exceptionType.substring(0, Math.min(3, exceptionType.length())).toUpperCase();
        
        return opCode + "-" + exCode + "-" + System.currentTimeMillis() % 10000;
    }
    
    /**
     * Formats a user-friendly error message with the error code
     */
    private static String formatUserMessage(LibraryException exception, String errorCode) {
        if (exception instanceof ItemNotFoundException) {
            return "The requested item could not be found. Please check the item ID and try again. (Error code: " + errorCode + ")";
        } else if (exception instanceof MemberNotFoundException) {
            return "The specified member could not be found. Please check the member ID and try again. (Error code: " + errorCode + ")";
        } else if (exception instanceof ItemAlreadyBorrowedException) {
            return "This item is already borrowed and not available. (Error code: " + errorCode + ")";
        } else if (exception instanceof ItemNotBorrowedException) {
            return "This item is not currently borrowed by this member. (Error code: " + errorCode + ")";
        } else {
            return exception.getMessage() + " (Error code: " + errorCode + ")";
        }
    }
}