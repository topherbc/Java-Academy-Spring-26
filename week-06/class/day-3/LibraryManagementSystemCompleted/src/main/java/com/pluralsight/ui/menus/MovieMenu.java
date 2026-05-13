package com.pluralsight.ui.menus;

import com.pluralsight.model.entities.Movie;
import com.pluralsight.service.Library;
import com.pluralsight.service.Logger;
import com.pluralsight.ui.MenuHandler;
import com.pluralsight.exceptions.*;
import java.util.Scanner;
import java.util.List;

/**
 * Menu handler for movie-related operations in the library system.
 * Provides user interface for viewing, searching, borrowing, and returning movies.
 * Handles movie-specific details like duration and director searches.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MovieMenu extends MenuHandler {
    private Library library;
    private Logger logger;

    public MovieMenu(Scanner scanner, Library library) {
        super(scanner);
        this.library = library;
        this.logger = Logger.getInstance();
    }

    public void display() {
        boolean inMovieMenu = true;
        while (inMovieMenu) {
            showMovieMenu();
            int choice = getChoice();
            logger.debug("User selected movie menu option: " + choice);

            switch (choice) {
                case 1:
                    viewAllMovies();
                    break;
                case 2:
                    viewAvailableMovies();
                    break;
                case 3:
                    searchMovies();
                    break;
                case 4:
                    searchMoviesByDirector();
                    break;
                case 5:
                    searchMoviesByGenre();
                    break;
                case 6:
                    borrowSpecificMovie();
                    break;
                case 7:
                    returnSpecificMovie();
                    break;
                case 8:
                    inMovieMenu = false;
                    break;
                default:
                    displayInvalidChoice();
            }
        }
    }

    private void showMovieMenu() {
        System.out.println("\n=== Movie Menu ===");
        System.out.println("1. View All Movies");
        System.out.println("2. View Available Movies");
        System.out.println("3. Search Movies");
        System.out.println("4. Search by Director");
        System.out.println("5. Search by Genre");
        System.out.println("6. Borrow Movie");
        System.out.println("7. Return Movie");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void viewAllMovies() {
        List<Movie> movies = library.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("No movies in the library.");
            return;
        }

        System.out.println("\n=== All Movies ===");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void viewAvailableMovies() {
        List<Movie> availableMovies = library.getAvailableMovies();
        if (availableMovies.isEmpty()) {
            System.out.println("No movies currently available.");
            return;
        }

        System.out.println("\n=== Available Movies ===");
        for (Movie movie : availableMovies) {
            System.out.println(movie);
        }
    }

    private void searchMovies() {
        System.out.print("Enter search term for movies (title, director, genre, or ID): ");
        String query = scanner.nextLine();

        List<Movie> results = library.searchMovies(query);
        if (results.isEmpty()) {
            System.out.println("No movies found matching your search.");
        } else {
            System.out.println("\n=== Movie Search Results ===");
            for (Movie movie : results) {
                System.out.println(movie);
            }
        }
    }

    private void searchMoviesByDirector() {
        System.out.print("Enter director name: ");
        String director = scanner.nextLine();

        List<Movie> results = library.searchMoviesByDirector(director);
        if (results.isEmpty()) {
            System.out.println("No movies found by director: " + director);
        } else {
            System.out.println("\n=== Movies by " + director + " ===");
            for (Movie movie : results) {
                System.out.println(movie);
            }
        }
    }

    private void searchMoviesByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        List<Movie> results = library.searchMovies(genre);
        if (results.isEmpty()) {
            System.out.println("No movies found in genre: " + genre);
        } else {
            System.out.println("\n=== Movies in " + genre + " ===");
            for (Movie movie : results) {
                System.out.println(movie);
            }
        }
    }

    private void borrowSpecificMovie() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter movie ID: ");
        String movieId = scanner.nextLine();

        try {
            library.borrowItem(memberId, movieId);
            System.out.println("Movie borrowed successfully!");
        } catch (LibraryException e) {
            String context = "Member: " + memberId + ", Movie: " + movieId;
            String errorMessage = ExceptionHandler.handleException(e, "borrow movie", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Unable to borrow movie: " + e.getMessage());
            logger.error("Unexpected error during movie borrow", e);
        }
    }

    private void returnSpecificMovie() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter movie ID: ");
        String movieId = scanner.nextLine();

        try {
            library.returnItem(memberId, movieId);
            System.out.println("Movie returned successfully!");
        } catch (LibraryException e) {
            String context = "Member: " + memberId + ", Movie: " + movieId;
            String errorMessage = ExceptionHandler.handleException(e, "return movie", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Unable to return movie: " + e.getMessage());
            logger.error("Unexpected error during movie return", e);
        }
    }
}
