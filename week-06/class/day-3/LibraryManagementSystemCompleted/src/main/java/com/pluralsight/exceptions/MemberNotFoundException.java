package com.pluralsight.exceptions;

/**
 * Exception thrown when attempting to access a member that does not exist.
 * Provides specific error messaging indicating which member ID was not found.
 * Used in Library operations when requesting members by ID.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class MemberNotFoundException extends LibraryException {
    public MemberNotFoundException(String memberId) {
        super("Member with ID '" + memberId + "' not found");
    }
}