package com.pluralsight.ui.menus;

import com.pluralsight.model.entities.Magazine;
import com.pluralsight.service.Library;
import com.pluralsight.service.Logger;
import com.pluralsight.ui.MenuHandler;
import com.pluralsight.exceptions.*;
import java.util.Scanner;
import java.util.List;

/**
 * Menu handler for magazine-related operations in the library system.
 * Provides user interface for viewing, searching, borrowing, and returning magazines.
 * Handles magazine-specific details like issue numbers and publication dates.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MagazineMenu extends MenuHandler {
    private Library library;
    private Logger logger;

    public MagazineMenu(Scanner scanner, Library library) {
        super(scanner);
        this.library = library;
        this.logger = Logger.getInstance();
    }

    public void display() {
        boolean inMagazineMenu = true;
        while (inMagazineMenu) {
            showMagazineMenu();
            int choice = getChoice();
            logger.debug("User selected magazine menu option: " + choice);

            switch (choice) {
                case 1:
                    viewAllMagazines();
                    break;
                case 2:
                    viewAvailableMagazines();
                    break;
                case 3:
                    searchMagazines();
                    break;
                case 4:
                    searchMagazinesByPublisher();
                    break;
                case 5:
                    searchMagazinesByGenre();
                    break;
                case 6:
                    borrowSpecificMagazine();
                    break;
                case 7:
                    returnSpecificMagazine();
                    break;
                case 8:
                    inMagazineMenu = false;
                    break;
                default:
                    displayInvalidChoice();
            }
        }
    }

    private void showMagazineMenu() {
        System.out.println("\n=== Magazine Menu ===");
        System.out.println("1. View All Magazines");
        System.out.println("2. View Available Magazines");
        System.out.println("3. Search Magazines");
        System.out.println("4. Search by Publisher");
        System.out.println("5. Search by Genre");
        System.out.println("6. Borrow Magazine");
        System.out.println("7. Return Magazine");
        System.out.println("8. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private void viewAllMagazines() {
        List<Magazine> magazines = library.getAllMagazines();
        if (magazines.isEmpty()) {
            System.out.println("No magazines in the library.");
            return;
        }

        System.out.println("\n=== All Magazines ===");
        for (Magazine magazine : magazines) {
            System.out.println(magazine);
        }
    }

    private void viewAvailableMagazines() {
        List<Magazine> availableMagazines = library.getAvailableMagazines();
        if (availableMagazines.isEmpty()) {
            System.out.println("No magazines currently available.");
            return;
        }

        System.out.println("\n=== Available Magazines ===");
        for (Magazine magazine : availableMagazines) {
            System.out.println(magazine);
        }
    }

    private void searchMagazines() {
        System.out.print("Enter search term for magazines (title, publisher, genre, or ID): ");
        String query = scanner.nextLine();

        List<Magazine> results = library.searchMagazines(query);
        if (results.isEmpty()) {
            System.out.println("No magazines found matching your search.");
        } else {
            System.out.println("\n=== Magazine Search Results ===");
            for (Magazine magazine : results) {
                System.out.println(magazine);
            }
        }
    }

    private void searchMagazinesByPublisher() {
        System.out.print("Enter publisher name: ");
        String publisher = scanner.nextLine();

        List<Magazine> results = library.searchMagazinesByPublisher(publisher);
        if (results.isEmpty()) {
            System.out.println("No magazines found by publisher: " + publisher);
        } else {
            System.out.println("\n=== Magazines by " + publisher + " ===");
            for (Magazine magazine : results) {
                System.out.println(magazine);
            }
        }
    }

    private void searchMagazinesByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        List<Magazine> results = library.searchMagazines(genre);
        if (results.isEmpty()) {
            System.out.println("No magazines found in genre: " + genre);
        } else {
            System.out.println("\n=== Magazines in " + genre + " ===");
            for (Magazine magazine : results) {
                System.out.println(magazine);
            }
        }
    }

    private void borrowSpecificMagazine() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter magazine ID: ");
        String magazineId = scanner.nextLine();

        try {
            library.borrowItem(memberId, magazineId);
            System.out.println("Magazine borrowed successfully!");
        } catch (LibraryException e) {
            String context = "Member: " + memberId + ", Magazine: " + magazineId;
            String errorMessage = ExceptionHandler.handleException(e, "borrow magazine", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Unable to borrow magazine: " + e.getMessage());
            logger.error("Unexpected error during magazine borrow", e);
        }
    }

    private void returnSpecificMagazine() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter magazine ID: ");
        String magazineId = scanner.nextLine();

        try {
            library.returnItem(memberId, magazineId);
            System.out.println("Magazine returned successfully!");
        } catch (LibraryException e) {
            String context = "Member: " + memberId + ", Magazine: " + magazineId;
            String errorMessage = ExceptionHandler.handleException(e, "return magazine", context);
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Unable to return magazine: " + e.getMessage());
            logger.error("Unexpected error during magazine return", e);
        }
    }
}
