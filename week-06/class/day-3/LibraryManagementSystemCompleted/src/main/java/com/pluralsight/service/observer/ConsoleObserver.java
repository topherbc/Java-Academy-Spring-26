package com.pluralsight.service.observer;

/**
 * Console implementation of the LibraryObserver.
 * Outputs library event notifications to the console.
 * Part of the Observer pattern implementation for Library events.
 * Provides real-time feedback on library operations to the user.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class ConsoleObserver extends LibraryObserver {
    @Override
    public void onItemBorrowed(String memberId, String memberName, String itemId, String itemTitle) {
        System.out.println("[NOTIFICATION] " + memberName + " (" + memberId + ") borrowed: " + itemTitle + " (" + itemId + ")");
    }
    
    @Override
    public void onItemReturned(String memberId, String memberName, String itemId, String itemTitle) {
        System.out.println("[NOTIFICATION] " + memberName + " (" + memberId + ") returned: " + itemTitle + " (" + itemId + ")");
    }
    
    @Override
    public void onMemberRegistered(String memberId, String memberName, String email) {
        System.out.println("[NOTIFICATION] New member registered: " + memberName + " (" + memberId + ") - " + email);
    }
    
    @Override
    public void onItemAdded(String itemId, String itemTitle, String itemType) {
        System.out.println("[NOTIFICATION] New " + itemType.toLowerCase() + " added: " + itemTitle + " (" + itemId + ")");
    }
}