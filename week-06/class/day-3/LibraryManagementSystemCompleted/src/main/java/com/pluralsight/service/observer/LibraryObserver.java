package com.pluralsight.service.observer;

/**
 * Base observer class for the Library Observer pattern.
 * Provides default implementations for library event notifications.
 * Subclasses can override these methods to handle specific events.
 * Used by the Library class to notify observers of important events.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class LibraryObserver {
    public void onItemBorrowed(String memberId, String memberName, String itemId, String itemTitle) {
        // Default implementation - can be overridden
    }
    
    public void onItemReturned(String memberId, String memberName, String itemId, String itemTitle) {
        // Default implementation - can be overridden
    }
    
    public void onMemberRegistered(String memberId, String memberName, String email) {
        // Default implementation - can be overridden
    }
    
    public void onItemAdded(String itemId, String itemTitle, String itemType) {
        // Default implementation - can be overridden
    }
}