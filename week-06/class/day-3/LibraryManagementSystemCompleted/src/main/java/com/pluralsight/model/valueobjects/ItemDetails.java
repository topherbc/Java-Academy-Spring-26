package com.pluralsight.model.valueobjects;

/**
 * Immutable value object representing details of a library item.
 * Contains metadata about an item such as title, creator, genre and description.
 * Used to transfer item details without exposing the full item entity.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class ItemDetails {
    private final String title;
    private final String creator;
    private final String genre;
    private final String description;
    
    public ItemDetails(String title, String creator, String genre, String description) {
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.description = description;
    }
    
    public String getTitle() { return title; }
    public String getCreator() { return creator; }
    public String getGenre() { return genre; }
    public String getDescription() { return description; }
    
    @Override
    public String toString() {
        return String.format("ItemDetails[title=%s, creator=%s, genre=%s, description=%s]",
            title, creator, genre, description);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemDetails that = (ItemDetails) obj;
        return title.equals(that.title) && 
               creator.equals(that.creator) && 
               genre.equals(that.genre) &&
               (description == null ? that.description == null : description.equals(that.description));
    }
    
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + creator.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}