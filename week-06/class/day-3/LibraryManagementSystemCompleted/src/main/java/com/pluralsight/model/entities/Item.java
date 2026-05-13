package com.pluralsight.model.entities;

import com.pluralsight.model.states.AvailableState;
import com.pluralsight.model.states.BorrowedState;
import com.pluralsight.model.states.ItemState;

/**
 * Base class for all library items (books, movies, magazines)
 * Implements the common functionality and properties shared by all item types.
 * Uses the State pattern to manage item availability states.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Item {
    protected String id;
    protected String title;
    protected String creator; // Could be author, director, publisher, etc.
    protected String genre;
    // Removed isAvailable field - availability is determined by state.canBorrow()
    protected ItemState state;

    public Item(String id, String title, String creator, String genre) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.state = new AvailableState(this);
    }

    public Item(String id, String title, String creator, String genre, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.state = isAvailable ? new AvailableState(this) : new BorrowedState(this);
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCreator() { return creator; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return state.canBorrow(); }

    // State management
    public void setState(ItemState state) {
        this.state = state;
    }

    public ItemState getState() { return state; }
    public String getStatus() { return state.getStatus(); }

    // Setters - uses state pattern correctly
    public void setAvailable(boolean available) {
        if (available && !isAvailable()) {
            setState(new AvailableState(this));
        } else if (!available && isAvailable()) {
            setState(new BorrowedState(this));
        }
        // State is set through the setState method for consistency
    }

    // Default implementations - can be overridden by subclasses
    public String getType() {
        return "Item";
    }

    public int getBorrowDuration() {
        return 7; // Default 1 week
    }

    @Override
    public String toString() {
        return String.format("%s | %s by %s [%s] - %s",
                id, title, creator, genre, getStatus());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}