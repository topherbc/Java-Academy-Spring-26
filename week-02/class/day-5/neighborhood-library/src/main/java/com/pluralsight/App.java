package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "978-0-13-468599-1", "The Pragmatic Programmer", null, false),
                new Book(2, "978-0-13-235088-4", "Clean Code", null, false),
                new Book(3, "978-0-596-51774-8", "JavaScript: The Good Parts", null, false),
                new Book(4, "978-0-13-110362-7", "The C Programming Language", null, false),
                new Book(5, "978-0-201-63361-0", "Design Patterns: Elements of Reusable Object-Oriented Software", null, false),
                new Book(6, "978-0-13-468599-1", "Refactoring: Improving the Design of Existing Code", null, false),
                new Book(7, "978-0-13-235088-4", "Introduction to Algorithms", null, false),
                new Book(8, "978-1-491-91205-8", "Learning Python", null, false),
                new Book(9, "978-0-13-601970-1", "The Mythical Man-Month", null, false),
                new Book(10, "978-0-201-70073-2", "Code Complete", null, false),
                new Book(11, "978-1-119-49740-9", "Clean Architecture", null, false),
                new Book(12, "978-0-13-235088-5", "Head First Java", null, false),
                new Book(13, "978-0-596-00712-6", "Structure and Interpretation of Computer Programs", null, false),
                new Book(14, "978-1-491-95038-8", "Effective Java", null, false),
                new Book(15, "978-0-13-468599-2", "You Don't Know JS", null, false),
                new Book(16, "978-0-13-235088-6", "The Art of Computer Programming", null, false),
                new Book(17, "978-1-491-91205-9", "Computer Networks", null, false),
                new Book(18, "978-0-13-601970-2", "Operating System Concepts", null, false),
                new Book(19, "978-0-201-70073-3", "Database System Concepts", null, false),
                new Book(20, "978-1-119-49740-0", "Cracking the Coding Interview", null, false)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library management tool!");

        boolean run = true;
        while(run) {
            System.out.println("\t1) Show Available Books");
            System.out.println("\t2) Show Checked Out Books");
            System.out.println("\t0) Exit");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> showAvailableBooks(books);
                case 2 -> showCheckedOutBooks(books);
                case 0 -> {
                    System.out.println("Goodbye");
                    run = false;
                }
            }
        }
    }

    public static void showAvailableBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println(books[i]);
            }
        }
    }

    public static void showCheckedOutBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println(books[i]);
            }
        }
    }
}
