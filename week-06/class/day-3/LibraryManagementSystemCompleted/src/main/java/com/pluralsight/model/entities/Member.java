package com.pluralsight.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a library member who can borrow and return items.
 * Each member has a unique ID, name, and email address.
 * Tracks borrowed items and their borrow dates for late fee calculation.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Member {
    private String memberId;
    private String name;
    private String email;
    private List<String> borrowedItems;
    private Map<String, String> borrowDates; // Maps itemId to borrow date (YYYY-MM-DD)
    
    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
        this.borrowDates = new HashMap<>();
    }
    
    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getBorrowedItems() { return new ArrayList<>(borrowedItems); }
    public Map<String, String> getBorrowDates() { return new HashMap<>(borrowDates); }
    
    // Item management
    public boolean borrowItem(String itemId) {
        if (!borrowedItems.contains(itemId)) {
            borrowedItems.add(itemId);
            // Record today's date as borrow date
            LocalDate today = LocalDate.now();
            borrowDates.put(itemId, today.format(DateTimeFormatter.ISO_DATE));
            return true;
        }
        return false; // Already borrowed this item
    }
    
    public boolean returnItem(String itemId) {
        boolean removed = borrowedItems.remove(itemId);
        if (removed) {
            borrowDates.remove(itemId);
        }
        return removed;
    }
    
    public boolean hasBorrowedItem(String itemId) {
        return borrowedItems.contains(itemId);
    }
    
    public int getBorrowedCount() {
        return borrowedItems.size();
    }
    
    /**
     * Gets the borrow date for a specific item
     * 
     * @param itemId The ID of the item
     * @return The borrow date as a string in ISO format (YYYY-MM-DD), or null if not found
     */
    public String getBorrowDate(String itemId) {
        if (itemId == null) {
            return null;
        }
        return borrowDates.get(itemId);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s (%s) - %d items borrowed", 
            memberId, name, email, borrowedItems.size());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return memberId.equals(member.memberId);
    }
    
    @Override
    public int hashCode() {
        return memberId.hashCode();
    }
}