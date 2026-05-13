package com.pluralsight.ui.menus;

import com.pluralsight.model.entities.Item;
import com.pluralsight.model.entities.Member;
import com.pluralsight.model.entities.Movie;
import com.pluralsight.model.entities.Magazine;
import com.pluralsight.model.entities.Book;
import com.pluralsight.service.Library;
import com.pluralsight.service.Logger;
import com.pluralsight.service.factory.BookBuilder;
import com.pluralsight.service.factory.MovieBuilder;
import com.pluralsight.service.factory.MagazineBuilder;
import com.pluralsight.ui.MenuHandler;
import com.pluralsight.exceptions.*;
import java.util.Scanner;
import java.util.List;

/**
 * Main menu handler for the Library Management System.
 * Provides the primary user interface for navigating to various functions.
 * Handles member registration, navigation to sub-menus, search, and admin functions.
 * Demonstrates exception handling throughout the user interface.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MainMenu extends MenuHandler {
    private Library library;
    private Logger logger;
    private BookMenu bookMenu;
    private MovieMenu movieMenu;
    private MagazineMenu magazineMenu;

    public MainMenu(Scanner scanner, Library library) {
        super(scanner);
        this.library = library;
        this.logger = Logger.getInstance();
        this.bookMenu = new BookMenu(scanner, library);
        this.movieMenu = new MovieMenu(scanner, library);
        this.magazineMenu = new MagazineMenu(scanner, library);
    }

    public void display() {
        System.out.println("\n=== Library Main Menu ===");
        System.out.println("1. Browse by Item Type (Books/Movies/Magazines)");
        System.out.println("2. Search All Items");
        System.out.println("3. Borrow Item");
        System.out.println("4. Return Item");
        System.out.println("5. Register New Member");
        System.out.println("6. View Member Information");
        System.out.println("7. View All Items");
        System.out.println("8. Admin: Add Item (Builder Demo)");
        System.out.println("9. Save and Exit");
        System.out.print("Enter your choice: ");
    }

    public boolean handleChoice(int choice) {
        logger.debug("User selected main menu option: " + choice);

        switch (choice) {
            case 1:
                browseByItemType();
                break;
            case 2:
                searchAllItems();
                break;
            case 3:
                borrowItem();
                break;
            case 4:
                returnItem();
                break;
            case 5:
                registerMember();
                break;
            case 6:
                viewMemberInfo();
                break;
            case 7:
                viewAllItems();
                break;
            case 8:
                addItemWithBuilder();
                break;
            case 9:
                return false; // Exit signal
            default:
                logger.warn("Invalid menu choice entered: " + choice);
                displayInvalidChoice();
        }
        return true; // Continue running
    }

    private void browseByItemType() {
        System.out.println("\n=== Browse by Item Type ===");
        System.out.println("1. Books");
        System.out.println("2. Movies");
        System.out.println("3. Magazines");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose item type: ");

        int choice = getChoice();
        logger.debug("User selected item type: " + choice);

        switch (choice) {
            case 1:
                bookMenu.display();
                break;
            case 2:
                movieMenu.display();
                break;
            case 3:
                magazineMenu.display();
                break;
            case 4:
                return;
            default:
                displayInvalidChoice();
        }
    }

    private void searchAllItems() {
        System.out.print("Enter search term (title, creator, genre, or ID): ");
        String query = scanner.nextLine();

        List<Item> results = library.searchItems(query);

        if (results.isEmpty()) {
            System.out.println("No items found matching your search.");
        } else {
            System.out.println("\n=== Search Results ===");
            for (Item item : results) {
                System.out.println(item);
            }
        }
    }

    private void borrowItem() {
        logger.debug("Borrow item operation initiated");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter item ID (ISBN for books, MVE for movies, MAG for magazines): ");
        String itemId = scanner.nextLine();

        try {
            library.borrowItem(memberId, itemId);
            System.out.println("Item borrowed successfully!");
        } catch (LibraryException e) {
            // Use centralized exception handler with context for user-friendly message
            String context = "Member: " + memberId + ", Item: " + itemId;
            String errorMessage = ExceptionHandler.handleException(e, "borrow", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            logger.error("Unexpected error during borrowing", e);
        }
    }

    private void returnItem() {
        logger.debug("Return item operation initiated");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        try {
            library.returnItem(memberId, itemId);
            System.out.println("Item returned successfully!");
        } catch (LibraryException e) {
            // Use centralized exception handler with context for user-friendly message
            String context = "Member: " + memberId + ", Item: " + itemId;
            String errorMessage = ExceptionHandler.handleException(e, "return", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            logger.error("Unexpected error during returning", e);
        }
    }

    private void registerMember() {
        logger.debug("Member registration initiated");
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        System.out.print("Enter member email: ");
        String email = scanner.nextLine();

        if (!Library.isValidEmail(email)) {
            System.out.println("Invalid email address.");
            return;
        }

        String memberId = Library.generateMemberId();
        Member member = new Member(memberId, name, email);

        if (library.addMember(member)) {
            System.out.println("Member registered successfully! Member ID: " + memberId);
        } else {
            System.out.println("Error registering member.");
        }
    }

    private void viewMemberInfo() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        try {
            Member member = library.getMember(memberId);
            
            System.out.println("\n=== Member Information ===");
            System.out.println(member);

            // Display late fees
            double lateFees = library.calculateLateFeesSafely(memberId);
            if (lateFees > 0) {
                System.out.println("Late Fees: $" + String.format("%.2f", lateFees));
            }

            List<String> borrowedItems = member.getBorrowedItems();
            if (!borrowedItems.isEmpty()) {
                System.out.println("\n=== Borrowed Items ===");
                for (String itemId : borrowedItems) {
                    Item item = library.getItemSafely(itemId);
                    if (item != null) {
                        String extraInfo = "";
                        if (item instanceof Movie) {
                            Movie movie = (Movie) item;
                            extraInfo = " (" + movie.getDuration() + " min)";
                        } else if (item instanceof Magazine) {
                            Magazine magazine = (Magazine) item;
                            extraInfo = " Issue: " + magazine.getIssueNumber() + " (" + magazine.getPublicationDate() + ")";
                        }
                        System.out.println("- " + item.getTitle() + " by " + item.getCreator() + " (" + item.getType() + ")" + extraInfo);
                    } else {
                        System.out.println("- Unknown item (ID: " + itemId + ")");
                        logger.warn("Borrowed item not found in library: " + itemId);
                    }
                }
            }
        } catch (LibraryException e) {
            String context = "Member ID: " + memberId;
            String errorMessage = ExceptionHandler.handleException(e, "view member info", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            logger.error("Unexpected error viewing member info", e);
        }
    }

    private void viewAllItems() {
        List<Item> items = library.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }

        System.out.println("\n=== All Items in Library ===");
        
        try {
            System.out.println("Books: " + library.getAllBooks().size());
            System.out.println("Movies: " + library.getAllMovies().size());
            System.out.println("Magazines: " + library.getAllMagazines().size());
            System.out.println();

            for (Item item : items) {
                System.out.println(item);
            }
        } catch (Exception e) {
            String errorMessage = "Error displaying items: " + e.getMessage();
            System.out.println(errorMessage);
            logger.error(errorMessage, e);
        }
    }
    
    /**
     * Demonstrates the Builder pattern by allowing the user to create a new item
     * with optional properties like description, rating, language, etc.
     */
    private void addItemWithBuilder() {
        System.out.println("\n=== Add Item (Builder Pattern Demo) ===");
        System.out.println("1. Add Book with Builder");
        System.out.println("2. Add Movie with Builder");
        System.out.println("3. Add Magazine with Builder");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose item type: ");
        
        int choice = getChoice();
        
        switch (choice) {
            case 1:
                addBookWithBuilder();
                break;
            case 2:
                addMovieWithBuilder();
                break;
            case 3:
                addMagazineWithBuilder();
                break;
            case 4:
                return;
            default:
                displayInvalidChoice();
        }
    }
    
    private void addBookWithBuilder() {
        System.out.println("\n=== Add Book with Builder ===");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        
        // Create a builder with required fields
        BookBuilder builder = new BookBuilder(isbn, title, author, genre);
        
        // Optional fields
        System.out.println("\nOptional Fields (press Enter to skip):");
        
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            builder.withDescription(description);
        }
        
        System.out.print("Enter Rating (1-5): ");
        String ratingStr = scanner.nextLine();
        if (!ratingStr.isEmpty()) {
            try {
                int rating = Integer.parseInt(ratingStr);
                builder.withRating(rating);
            } catch (NumberFormatException e) {
                System.out.println("Invalid rating format. Using default.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rating value. Using default.");
            }
        }
        
        System.out.print("Enter Language: ");
        String language = scanner.nextLine();
        if (!language.isEmpty()) {
            builder.withLanguage(language);
        }
        
        System.out.print("Enter Edition: ");
        String edition = scanner.nextLine();
        if (!edition.isEmpty()) {
            builder.withEdition(edition);
        }
        
        // Build the book and add to library
        Book book = builder.build();
        
        if (library.addItem(book)) {
            System.out.println("Book added successfully!");
            System.out.println("Added: " + book);
        } else {
            System.out.println("Failed to add book. ISBN may already exist.");
        }
    }
    
    private void addMovieWithBuilder() {
        System.out.println("\n=== Add Movie with Builder ===");
        System.out.print("Enter Movie ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Director: ");
        String director = scanner.nextLine();
        
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter Duration (minutes): ");
        int duration = 0;
        try {
            duration = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid duration. Using 90 minutes as default.");
            duration = 90;
        }
        
        // Create a builder with required fields
        MovieBuilder builder = new MovieBuilder(id, title, director, genre, duration);
        
        // Optional fields
        System.out.println("\nOptional Fields (press Enter to skip):");
        
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            builder.withDescription(description);
        }
        
        System.out.print("Enter Rating (1-5): ");
        String ratingStr = scanner.nextLine();
        if (!ratingStr.isEmpty()) {
            try {
                int rating = Integer.parseInt(ratingStr);
                builder.withRating(rating);
            } catch (NumberFormatException e) {
                System.out.println("Invalid rating format. Using default.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rating value. Using default.");
            }
        }
        
        System.out.print("Enter Language: ");
        String language = scanner.nextLine();
        if (!language.isEmpty()) {
            builder.withLanguage(language);
        }
        
        // Build the movie and add to library
        Movie movie = builder.build();
        
        if (library.addItem(movie)) {
            System.out.println("Movie added successfully!");
            System.out.println("Added: " + movie);
        } else {
            System.out.println("Failed to add movie. ID may already exist.");
        }
    }
    
    private void addMagazineWithBuilder() {
        System.out.println("\n=== Add Magazine with Builder ===");
        System.out.print("Enter Magazine ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter Issue Number: ");
        String issueNumber = scanner.nextLine();
        
        System.out.print("Enter Publication Date (YYYY-MM-DD): ");
        String publicationDate = scanner.nextLine();
        
        // Create a builder with required fields
        MagazineBuilder builder = new MagazineBuilder(id, title, publisher, genre, issueNumber, publicationDate);
        
        // Optional fields
        System.out.println("\nOptional Fields (press Enter to skip):");
        
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            builder.withDescription(description);
        }
        
        System.out.print("Enter Rating (1-5): ");
        String ratingStr = scanner.nextLine();
        if (!ratingStr.isEmpty()) {
            try {
                int rating = Integer.parseInt(ratingStr);
                builder.withRating(rating);
            } catch (NumberFormatException e) {
                System.out.println("Invalid rating format. Using default.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rating value. Using default.");
            }
        }
        
        System.out.print("Enter Language: ");
        String language = scanner.nextLine();
        if (!language.isEmpty()) {
            builder.withLanguage(language);
        }
        
        // Build the magazine and add to library
        Magazine magazine = builder.build();
        
        if (library.addItem(magazine)) {
            System.out.println("Magazine added successfully!");
            System.out.println("Added: " + magazine);
        } else {
            System.out.println("Failed to add magazine. ID may already exist.");
        }
    }
}