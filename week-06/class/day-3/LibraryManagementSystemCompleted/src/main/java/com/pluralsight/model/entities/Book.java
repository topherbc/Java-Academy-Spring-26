package com.pluralsight.model.entities;

/**
 * Represents a book in the library system.
 * Books are identified by ISBNs and have authors.
 * Default borrow duration for books is 2 weeks (14 days).
 * Implements custom equality based on ISBN.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Book extends Item {
    
    public Book(String isbn, String title, String author, String genre) {
        super(isbn, title, author, genre);
    }
    
    public Book(String isbn, String title, String author, String genre, boolean isAvailable) {
        super(isbn, title, author, genre, isAvailable);
    }
    
    // Convenience methods for books
    public String getIsbn() { 
        return getId(); 
    }
    
    public String getAuthor() { 
        return getCreator(); 
    }
    
    @Override
    public String getType() {
        return "Book";
    }
    
    @Override
    public int getBorrowDuration() {
        return 14; // 2 weeks for books
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s by %s [%s] - %s", 
            getIsbn(), getTitle(), getAuthor(), getGenre(), 
            isAvailable() ? "Available" : "Borrowed");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return getIsbn().equals(book.getIsbn());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return getIsbn().hashCode();
    }
}