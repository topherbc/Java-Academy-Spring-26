package com.pluralsight.exceptions;

/**
 * Exception thrown when attempting to return an item that is not currently borrowed.
 * Provides specific error messaging indicating which item ID is not borrowed
 * by the specified member.
 * Used in Library's return operations to prevent invalid returns.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class ItemNotBorrowedException extends LibraryException {
    public ItemNotBorrowedException(String itemId, String memberId) {
        super("Item '" + itemId + "' is not currently borrowed by member '" + memberId + "'");
    }
}