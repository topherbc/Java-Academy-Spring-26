package com.pluralsight.service.factory;

import com.pluralsight.model.entities.Book;
import com.pluralsight.model.entities.Movie;
import com.pluralsight.model.entities.Magazine;

/**
 * Factory class for creating different types of library items.
 * Implements the Factory pattern to centralize item creation logic.
 * Provides validation of required fields before creating items.
 * Supports creation of books, movies, and magazines with various parameters.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class ItemFactory {
    
    public static Book createBook(String isbn, String title, String author, String genre) {
        validateBasicFields(isbn, title, author, genre);
        return new Book(isbn, title, author, genre);
    }
    
    public static Book createBook(String isbn, String title, String author, String genre, boolean isAvailable) {
        validateBasicFields(isbn, title, author, genre);
        return new Book(isbn, title, author, genre, isAvailable);
    }
    
    public static Movie createMovie(String movieId, String title, String director, String genre, int duration) {
        validateBasicFields(movieId, title, director, genre);
        validateDuration(duration);
        return new Movie(movieId, title, director, genre, duration);
    }
    
    public static Movie createMovie(String movieId, String title, String director, String genre, int duration, boolean isAvailable) {
        validateBasicFields(movieId, title, director, genre);
        validateDuration(duration);
        return new Movie(movieId, title, director, genre, duration, isAvailable);
    }
    
    public static Magazine createMagazine(String magazineId, String title, String publisher, String genre, 
                                         String issueNumber, String publicationDate) {
        validateBasicFields(magazineId, title, publisher, genre);
        validateMagazineFields(issueNumber, publicationDate);
        return new Magazine(magazineId, title, publisher, genre, issueNumber, publicationDate);
    }
    
    public static Magazine createMagazine(String magazineId, String title, String publisher, String genre, 
                                         String issueNumber, String publicationDate, boolean isAvailable) {
        validateBasicFields(magazineId, title, publisher, genre);
        validateMagazineFields(issueNumber, publicationDate);
        return new Magazine(magazineId, title, publisher, genre, issueNumber, publicationDate, isAvailable);
    }
    
    private static void validateBasicFields(String id, String title, String creator, String genre) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (creator == null || creator.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator cannot be null or empty");
        }
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty");
        }
    }
    
    private static void validateDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
    }
    
    private static void validateMagazineFields(String issueNumber, String publicationDate) {
        if (issueNumber == null || issueNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Issue number cannot be null or empty");
        }
        if (publicationDate == null || publicationDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Publication date cannot be null or empty");
        }
    }
}