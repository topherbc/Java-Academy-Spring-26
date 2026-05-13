package com.pluralsight.service.factory;

import com.pluralsight.model.entities.Book;

/**
 * Builder class for creating Book instances with optional attributes.
 * Implements the Builder pattern to provide a flexible way to construct Book objects.
 * Allows setting various optional attributes before building the final Book object.
 * Required attributes are passed in the constructor, optional ones through setter methods.
 *
 * @author Library Management System Team
 * @version 1.0
 */
public class BookBuilder {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    // These fields are available for future extension but not currently used in the base Book class
    private String description;
    private int rating;
    private String language;
    private String edition;
    private boolean isAvailable = true;
    
    public BookBuilder(String isbn, String title, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    
    public BookBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public BookBuilder withRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
        return this;
    }
    
    public BookBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }
    
    public BookBuilder withEdition(String edition) {
        this.edition = edition;
        return this;
    }
    
    public BookBuilder isAvailable(boolean available) {
        this.isAvailable = available;
        return this;
    }
    
    public Book build() {
        Book book = new Book(isbn, title, author, genre, isAvailable);
        // TODO: In a real application, we would extend Book class to use these additional fields
        // or pass them to a BookDetails value object
        return book;
    }
}