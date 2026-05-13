package com.pluralsight.exceptions;

/**
 * Exception thrown when attempting to access an item that does not exist.
 * Provides specific error messaging indicating which item ID was not found.
 * Used in Library operations when requesting items by ID.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class ItemNotFoundException extends LibraryException {
    public ItemNotFoundException(String itemId) {
        super("Item with ID '" + itemId + "' not found");
    }
}