package com.pluralsight.model.entities;

/**
 * Represents a movie in the library system.
 * Movies have directors and durations (in minutes).
 * Default borrow duration for movies is 3 days.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Movie extends Item {
    private int duration; // in minutes
    
    public Movie(String movieId, String title, String director, String genre, int duration) {
        super(movieId, title, director, genre);
        this.duration = duration;
    }
    
    public Movie(String movieId, String title, String director, String genre, int duration, boolean isAvailable) {
        super(movieId, title, director, genre, isAvailable);
        this.duration = duration;
    }
    
    public int getDuration() { 
        return duration; 
    }
    
    public String getDirector() { 
        return getCreator(); 
    }
    
    @Override
    public String getType() {
        return "Movie";
    }
    
    @Override
    public int getBorrowDuration() {
        return 3; // 3 days for movies
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s directed by %s [%s] (%d min) - %s", 
            getId(), getTitle(), getDirector(), getGenre(), duration,
            isAvailable() ? "Available" : "Borrowed");
    }
}