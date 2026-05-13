package com.pluralsight.exceptions;

/**
 * Exception thrown when attempting to borrow an item that is already borrowed.
 * Provides specific error messaging indicating which item ID is already borrowed
 * and by which member.
 * Used in Library's borrowing operations to prevent duplicate borrowing.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class ItemAlreadyBorrowedException extends LibraryException {
    public ItemAlreadyBorrowedException(String itemId, String memberId) {
        super("Item '" + itemId + "' is already borrowed by member '" + memberId + "'");
    }
}