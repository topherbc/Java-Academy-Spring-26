package com.pluralsight.service.factory;

import com.pluralsight.model.entities.Movie;

/**
 * Builder class for creating Movie instances with optional attributes.
 * Implements the Builder pattern to provide a flexible way to construct Movie objects.
 * Required attributes are set in the constructor, optional ones through setter methods.
 * Provides a fluent interface for method chaining.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MovieBuilder {
    private String id;
    private String title;
    private String director;
    private String genre;
    private int duration;
    // These fields are available for future extension but not currently used in the base Movie class
    private String description;
    private int rating;
    private String language;
    private boolean isAvailable = true;
    
    public MovieBuilder(String id, String title, String director, String genre, int duration) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
    }
    
    public MovieBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public MovieBuilder withRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
        return this;
    }
    
    public MovieBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }
    
    public MovieBuilder isAvailable(boolean available) {
        this.isAvailable = available;
        return this;
    }
    
    public Movie build() {
        Movie movie = new Movie(id, title, director, genre, duration, isAvailable);
        // TODO: In a real application, we would extend Movie class to use these additional fields
        // or pass them to a MovieDetails value object
        return movie;
    }
}