package com.pluralsight.service.factory;

import com.pluralsight.model.entities.Magazine;

/**
 * Builder class for creating Magazine instances with optional attributes.
 * Implements the Builder pattern to provide a flexible way to construct Magazine objects.
 * Required attributes are set in the constructor, optional ones through setter methods.
 * Handles magazine-specific attributes like issue number and publication date.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MagazineBuilder {
    private String id;
    private String title;
    private String publisher;
    private String genre;
    private String issueNumber;
    private String publicationDate;
    // These fields are available for future extension but not currently used in the base Magazine class
    private String description;
    private int rating;
    private String language;
    private boolean isAvailable = true;
    
    public MagazineBuilder(String id, String title, String publisher, String genre, String issueNumber, String publicationDate) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }
    
    public MagazineBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public MagazineBuilder withRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
        return this;
    }
    
    public MagazineBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }
    
    public MagazineBuilder isAvailable(boolean available) {
        this.isAvailable = available;
        return this;
    }
    
    public Magazine build() {
        Magazine magazine = new Magazine(id, title, publisher, genre, issueNumber, publicationDate, isAvailable);
        // TODO: In a real application, we would extend Magazine class to use these additional fields
        // or pass them to a MagazineDetails value object
        return magazine;
    }
}