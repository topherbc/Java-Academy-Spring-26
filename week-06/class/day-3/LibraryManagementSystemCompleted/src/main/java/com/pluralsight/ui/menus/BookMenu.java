package com.pluralsight.ui.menus;

import com.pluralsight.model.entities.Book;
import com.pluralsight.model.entities.Item;
import com.pluralsight.service.Library;
import com.pluralsight.service.Logger;
import com.pluralsight.ui.MenuHandler;
import com.pluralsight.exceptions.*;
import java.util.Scanner;
import java.util.List;

/**
 * Menu handler for book-related operations in the library system.
 * Provides user interface for viewing, searching, borrowing, and returning books.
 * Implements exception handling for all library operations involving books.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class BookMenu extends MenuHandler {
    private Library library;
    private Logger logger;

    public BookMenu(Scanner scanner, Library library) {
        super(scanner);
        this.library = library;
        this.logger = Logger.getInstance();
    }

    public void display() {
        boolean inBookMenu = true;
        while (inBookMenu) {
            showBookMenu();
            int choice = getChoice();
            logger.debug("User selected book menu option: " + choice);

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    viewAvailableBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    searchBooksByAuthor();
                    break;
                case 5:
                    searchBooksByGenre();
                    break;
                case 6:
                    borrowSpecificBook();
                    break;
                case 7:
                    returnSpecificBook();
                    break;
                case 8:
                    inBookMenu = false;
                    break;
                default:
                    displayInvalidChoice();
            }
        }
    }

    private void showBookMenu() {
        System.out.println("\n=== Book Menu ===");
        System.out.println("1. View All Books");
        System.out.println("2. View Available Books");
        System.out.println("3. Search Books");
        System.out.println("4. Search by Author");
        System.out.println("5. Search by Genre");
        System.out.println("6. Borrow Book");
        System.out.println("7. Return Book");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void viewAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n=== All Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void viewAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books currently available.");
            return;
        }

        System.out.println("\n=== Available Books ===");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    private void searchBooks() {
        System.out.print("Enter search term for books (title, author, genre, or ISBN): ");
        String query = scanner.nextLine();

        List<Book> results = library.searchBooks(query);
        if (results.isEmpty()) {
            System.out.println("No books found matching your search.");
        } else {
            System.out.println("\n=== Book Search Results ===");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private void searchBooksByAuthor() {
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        List<Book> results = library.searchByAuthor(author);
        if (results.isEmpty()) {
            System.out.println("No books found by author: " + author);
        } else {
            System.out.println("\n=== Books by " + author + " ===");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private void searchBooksByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        List<Item> results = library.searchByGenre(genre);
        if (results.isEmpty()) {
            System.out.println("No books found in genre: " + genre);
        } else {
            System.out.println("\n=== Books in " + genre + " ===");
            for (Item book : results) {
                System.out.println(book);
            }
        }
    }

    private void borrowSpecificBook() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        try {
            library.borrowItem(memberId, isbn);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            String context = "Member: " + memberId + ", ISBN: " + isbn;
            handleLibraryException(e, "borrow book", context);
        }
    }

    private void returnSpecificBook() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        try {
            library.returnItem(memberId, isbn);
            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            String context = "Member: " + memberId + ", ISBN: " + isbn;
            handleLibraryException(e, "return book", context);
        }
    }
}