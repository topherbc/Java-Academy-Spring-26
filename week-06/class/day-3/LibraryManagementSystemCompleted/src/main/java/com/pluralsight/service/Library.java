package com.pluralsight.service;

import com.pluralsight.model.entities.Item;
import com.pluralsight.model.entities.Book;
import com.pluralsight.model.entities.Movie;
import com.pluralsight.model.entities.Magazine;
import com.pluralsight.model.entities.Member;
import com.pluralsight.service.observer.LibraryObserver;
import com.pluralsight.exceptions.*;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Main service class for the Library Management System.
 * Implements the Singleton pattern to ensure only one instance exists.
 * Handles all library operations including item and member management, 
 * searching, borrowing/returning items, and data persistence.
 * Also implements the Observer pattern for event notifications.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class Library {
    private static Library instance;
    private Map<String, Item> items;
    private Map<String, Member> members;
    private static int memberCounter = 1000;
    private Logger logger = Logger.getInstance();
    private ArrayList<LibraryObserver> observers;
    
    private Library() {
        this.items = new HashMap<>();
        this.members = new HashMap<>();
        this.observers = new ArrayList<>();
        logger.info("Library system initialized as Singleton");
    }
    
    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }
    
    // Observer management
    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }
    
    private void notifyItemBorrowed(String memberId, String memberName, String itemId, String itemTitle) {
        for (LibraryObserver observer : observers) {
            observer.onItemBorrowed(memberId, memberName, itemId, itemTitle);
        }
    }
    
    private void notifyItemReturned(String memberId, String memberName, String itemId, String itemTitle) {
        for (LibraryObserver observer : observers) {
            observer.onItemReturned(memberId, memberName, itemId, itemTitle);
        }
    }
    
    private void notifyMemberRegistered(String memberId, String memberName, String email) {
        for (LibraryObserver observer : observers) {
            observer.onMemberRegistered(memberId, memberName, email);
        }
    }
    
    private void notifyItemAdded(String itemId, String itemTitle, String itemType) {
        for (LibraryObserver observer : observers) {
            observer.onItemAdded(itemId, itemTitle, itemType);
        }
    }
    
    // Item management
    public boolean addItem(Item item) {
        if (!items.containsKey(item.getId())) {
            items.put(item.getId(), item);
            logger.info("Item added: " + item.getTitle() + " (ID: " + item.getId() + ")");
            notifyItemAdded(item.getId(), item.getTitle(), item.getType());
            return true;
        }
        logger.warn("Attempted to add duplicate item: " + item.getId());
        return false; // Item already exists
    }
    
    /**
     * Gets an item by its ID
     * 
     * @param id The item ID to retrieve
     * @return The item with the specified ID
     * @throws ItemNotFoundException if no item with the ID exists
     */
    public Item getItem(String id) throws ItemNotFoundException {
        Item item = items.get(id);
        if (item == null) {
            logger.warn("Item not found: " + id);
            
            // Check if ID follows any known pattern to give better feedback
            String itemType = "unknown";
            if (id.startsWith("978") || id.length() == 10 || id.length() == 13) {
                itemType = "book";
            } else if (id.startsWith("MOV") || id.startsWith("DVD")) {
                itemType = "movie";
            } else if (id.startsWith("MAG")) {
                itemType = "magazine";
            }
            
            logger.error("Item not found - ID: " + id + ", Type: " + itemType);
            throw new ItemNotFoundException(id);
        }
        return item;
    }
    
    /**
     * Gets an item safely, returning null instead of throwing an exception if not found
     * 
     * @param id The item ID to retrieve
     * @return The item with the specified ID, or null if not found or if id is null
     */
    public Item getItemSafely(String id) {
        if (id == null) {
            logger.warn("Safe item retrieval called with null ID");
            return null;
        }
        
        try {
            return getItem(id);
        } catch (ItemNotFoundException e) {
            logger.warn("Safe item retrieval returned null for ID: " + id);
            return null;
        }
    }
    
    public List<Item> getAllItems() {
        logger.debug("Retrieved all items, count: " + items.size());
        return new ArrayList<>(items.values());
    }
    
    public List<Item> getAvailableItems() {
        List<Item> available = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.isAvailable()) {
                available.add(item);
            }
        }
        logger.debug("Retrieved available items, count: " + available.size());
        return available;
    }
    
    // Backward compatibility methods for books
    public boolean addBook(Book book) {
        return addItem(book);
    }
    
    public Book getBook(String isbn) {
        try {
            Item item = getItem(isbn);
            return (item instanceof Book) ? (Book) item : null;
        } catch (ItemNotFoundException e) {
            logger.warn("Book not found with ISBN: " + isbn);
            return null;
        }
    }
    
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Book) {
                books.add((Book) item);
            }
        }
        return books;
    }
    
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Book && item.isAvailable()) {
                availableBooks.add((Book) item);
            }
        }
        return availableBooks;
    }
    
    // Movie management methods
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Movie) {
                movies.add((Movie) item);
            }
        }
        logger.debug("Retrieved all movies, count: " + movies.size());
        return movies;
    }
    
    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Movie && item.isAvailable()) {
                availableMovies.add((Movie) item);
            }
        }
        logger.debug("Retrieved available movies, count: " + availableMovies.size());
        return availableMovies;
    }
    
    public List<Movie> searchMoviesByDirector(String director) {
        List<Movie> results = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Movie) {
                Movie movie = (Movie) item;
                if (movie.getDirector().toLowerCase().contains(director.toLowerCase())) {
                    results.add(movie);
                }
            }
        }
        logger.info("Director search for '" + director + "' in movies, results: " + results.size());
        return results;
    }
    
    public List<Movie> searchMovies(String query) {
        List<Movie> results = new ArrayList<>();
        query = query.toLowerCase();
        
        for (Item item : items.values()) {
            if (item instanceof Movie) {
                Movie movie = (Movie) item;
                if (movie.getTitle().toLowerCase().contains(query) ||
                    movie.getDirector().toLowerCase().contains(query) ||
                    movie.getGenre().toLowerCase().contains(query) ||
                    movie.getId().toLowerCase().contains(query)) {
                    results.add(movie);
                }
            }
        }
        logger.info("Search performed in movies for: '" + query + "', results: " + results.size());
        return results;
    }
    
    // Magazine management methods
    public List<Magazine> getAllMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Magazine) {
                magazines.add((Magazine) item);
            }
        }
        logger.debug("Retrieved all magazines, count: " + magazines.size());
        return magazines;
    }
    
    public List<Magazine> getAvailableMagazines() {
        List<Magazine> availableMagazines = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Magazine && item.isAvailable()) {
                availableMagazines.add((Magazine) item);
            }
        }
        logger.debug("Retrieved available magazines, count: " + availableMagazines.size());
        return availableMagazines;
    }
    
    public List<Magazine> searchMagazinesByPublisher(String publisher) {
        List<Magazine> results = new ArrayList<>();
        for (Item item : items.values()) {
            if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                    results.add(magazine);
                }
            }
        }
        logger.info("Publisher search for '" + publisher + "' in magazines, results: " + results.size());
        return results;
    }
    
    public List<Magazine> searchMagazines(String query) {
        List<Magazine> results = new ArrayList<>();
        query = query.toLowerCase();
        
        for (Item item : items.values()) {
            if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getTitle().toLowerCase().contains(query) ||
                    magazine.getPublisher().toLowerCase().contains(query) ||
                    magazine.getGenre().toLowerCase().contains(query) ||
                    magazine.getId().toLowerCase().contains(query)) {
                    results.add(magazine);
                }
            }
        }
        logger.info("Search performed in magazines for: '" + query + "', results: " + results.size());
        return results;
    }
    
    // Member management
    public boolean addMember(Member member) {
        if (!members.containsKey(member.getMemberId())) {
            members.put(member.getMemberId(), member);
            logger.info("Member registered: " + member.getName() + " (ID: " + member.getMemberId() + ")");
            notifyMemberRegistered(member.getMemberId(), member.getName(), member.getEmail());
            return true;
        }
        logger.warn("Attempted to add duplicate member: " + member.getMemberId());
        return false; // Member already exists
    }
    
    public Member getMember(String memberId) throws MemberNotFoundException {
        Member member = members.get(memberId);
        if (member == null) {
            logger.warn("Member not found: " + memberId);
            throw new MemberNotFoundException(memberId);
        }
        return member;
    }
    
    public static String generateMemberId() {
        return "M" + (++memberCounter);
    }
    
    // Search functionality
    public List<Item> searchItems(String query) {
        List<Item> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        
        for (Item item : items.values()) {
            if (item.getTitle().toLowerCase().contains(lowerQuery) ||
                item.getCreator().toLowerCase().contains(lowerQuery) ||
                item.getGenre().toLowerCase().contains(lowerQuery) ||
                item.getId().toLowerCase().contains(lowerQuery)) {
                results.add(item);
            }
        }
        logger.info("Search performed for: '" + query + "', results: " + results.size());
        return results;
    }
    
    public List<Item> searchByGenre(String genre) {
        List<Item> results = new ArrayList<>();
        for (Item item : items.values()) {
            // Exact match with case insensitivity
            if (item.getGenre().equalsIgnoreCase(genre)) {
                results.add(item);
            }
        }
        logger.info("Genre search for '" + genre + "', results: " + results.size());
        return results;
    }
    
    public List<Item> searchByCreator(String creator) {
        List<Item> results = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.getCreator().toLowerCase().contains(creator.toLowerCase())) {
                results.add(item);
            }
        }
        logger.info("Creator search for '" + creator + "', results: " + results.size());
        return results;
    }
    
    // Backward compatibility for book searches
    public List<Book> searchBooks(String query) {
        List<Book> bookResults = new ArrayList<>();
        List<Item> allResults = searchItems(query);
        for (Item item : allResults) {
            if (item instanceof Book) {
                bookResults.add((Book) item);
            }
        }
        return bookResults;
    }
    
    public List<Book> searchByAuthor(String author) {
        List<Book> bookResults = new ArrayList<>();
        List<Item> allResults = searchByCreator(author);
        for (Item item : allResults) {
            if (item instanceof Book) {
                bookResults.add((Book) item);
            }
        }
        return bookResults;
    }
    
    // Transaction ID counter for unique IDs within the session
    private static final java.util.concurrent.atomic.AtomicLong transactionCounter = new java.util.concurrent.atomic.AtomicLong(1);
    
    /**
     * Generates a unique transaction ID for logging and tracking purposes
     * 
     * @param prefix Prefix to identify the type of transaction (e.g., "BORROW", "RETURN")
     * @return A unique transaction ID string
     */
    private String generateTransactionId(String prefix) {
        // Format: PREFIX-TIMESTAMP-COUNTER (where counter ensures uniqueness even for same-millisecond transactions)
        return prefix + "-" + 
               String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date()) + "-" + 
               transactionCounter.getAndIncrement();
    }
    
    // Borrow/Return operations
    public void borrowItem(String memberId, String itemId) 
            throws MemberNotFoundException, ItemNotFoundException, ItemAlreadyBorrowedException {
        
        // Track transaction ID for logging
        String transactionId = generateTransactionId("BORROW");
        logger.debug("Starting borrow transaction " + transactionId + " - Member: " + memberId + ", Item: " + itemId);
        
        Member member = members.get(memberId);
        if (member == null) {
            logger.error("[" + transactionId + "] Borrow attempt failed - Member not found: " + memberId);
            throw new MemberNotFoundException(memberId);
        }
        
        Item item = items.get(itemId);
        if (item == null) {
            logger.error("[" + transactionId + "] Borrow attempt failed - Item not found: " + itemId);
            throw new ItemNotFoundException(itemId);
        }
        
        if (!item.isAvailable()) {
            // Try to find who has the item
            String currentBorrower = "unknown";
            for (Member m : members.values()) {
                if (m.hasBorrowedItem(itemId)) {
                    currentBorrower = m.getMemberId();
                    break;
                }
            }
            
            logger.warn("[" + transactionId + "] Borrow attempt failed - Item not available: " + 
                        item.getTitle() + " (ID: " + itemId + "), Type: " + item.getType() + 
                        ", Current borrower: " + currentBorrower);
                        
            throw new ItemAlreadyBorrowedException(itemId, "another member"); 
        }
        
        if (member.hasBorrowedItem(itemId)) {
            logger.warn("[" + transactionId + "] Borrow attempt failed - Member " + 
                       member.getName() + " already has item: " + item.getTitle());
            throw new ItemAlreadyBorrowedException(itemId, memberId);
        }
        
        // Log borrowing details including item metadata
        logger.info("[" + transactionId + "] Attempting to borrow - Member: " + member.getName() + 
                   ", Item: " + item.getTitle() + ", Type: " + item.getType() + 
                   ", Currently borrowed items: " + member.getBorrowedCount());
        
        boolean borrowResult = member.borrowItem(itemId);
        if (borrowResult) {
            item.setAvailable(false);
            
            logger.info("[" + transactionId + "] Item borrowed successfully - Member: " + 
                       member.getName() + " (" + memberId + "), Item: " + item.getTitle() + 
                       " (" + itemId + "), Borrow duration: " + item.getBorrowDuration() + " days");
                       
            notifyItemBorrowed(memberId, member.getName(), itemId, item.getTitle());
        } else {
            logger.warn("[" + transactionId + "] Borrow attempt failed - Member already has item or borrowing limit reached: " + 
                       memberId + ", Current borrowed count: " + member.getBorrowedCount());
                       
            throw new ItemAlreadyBorrowedException(itemId, memberId);
        }
    }
    
    public void returnItem(String memberId, String itemId) 
            throws MemberNotFoundException, ItemNotFoundException, ItemNotBorrowedException {
        
        // Track transaction ID for logging
        String transactionId = generateTransactionId("RETURN");
        logger.debug("Starting return transaction " + transactionId + " - Member: " + memberId + ", Item: " + itemId);
        
        Member member = members.get(memberId);
        if (member == null) {
            logger.error("[" + transactionId + "] Return attempt failed - Member not found: " + memberId);
            throw new MemberNotFoundException(memberId);
        }
        
        Item item = items.get(itemId);
        if (item == null) {
            logger.error("[" + transactionId + "] Return attempt failed - Item not found: " + itemId);
            throw new ItemNotFoundException(itemId);
        }
        
        if (!member.hasBorrowedItem(itemId)) {
            logger.warn("[" + transactionId + "] Return attempt failed - Member doesn't have item: " + memberId + ", ID: " + itemId);
            throw new ItemNotBorrowedException(itemId, memberId);
        }
        
        item.setAvailable(true);
        member.returnItem(itemId);
        logger.info("[" + transactionId + "] Item returned successfully - Member: " + member.getName() + 
                    " (" + memberId + "), Item: " + item.getTitle() + " (" + itemId + ")");
        notifyItemReturned(memberId, member.getName(), itemId, item.getTitle());
    }
    
    // Backward compatibility methods
    // These methods are deprecated but maintained for backwards compatibility
    // They will be removed in a future version
    
    /**
     * @deprecated Use borrowItem instead, which provides proper exception handling
     */
    @Deprecated
    public boolean borrowBook(String memberId, String isbn) {
        try {
            borrowItem(memberId, isbn);
            return true;
        } catch (MemberNotFoundException | ItemNotFoundException | ItemAlreadyBorrowedException e) {
            String transactionId = generateTransactionId("BC-BORROW");
            logger.error("[" + transactionId + "] Borrow book failed: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * @deprecated Use returnItem instead, which provides proper exception handling
     */
    @Deprecated
    public boolean returnBook(String memberId, String isbn) {
        try {
            returnItem(memberId, isbn);
            return true;
        } catch (MemberNotFoundException | ItemNotFoundException | ItemNotBorrowedException e) {
            String transactionId = generateTransactionId("BC-RETURN");
            logger.error("[" + transactionId + "] Return book failed: " + e.getMessage());
            return false;
        }
    }
    
    // Late fee functionality (Bonus Ticket #19)
    public double calculateLateFees(String memberId) throws MemberNotFoundException {
        Member member = members.get(memberId);
        if (member == null) {
            logger.warn("Member not found for late fee calculation: " + memberId);
            throw new MemberNotFoundException(memberId);
        }
        
        double totalFees = 0.0;
        Map<String, String> borrowDates = member.getBorrowDates();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        
        for (String itemId : member.getBorrowedItems()) {
            Item item = items.get(itemId);
            if (item != null) {
                String borrowDateStr = borrowDates.get(itemId);
                if (borrowDateStr != null) {
                    try {
                        LocalDate borrowDate = LocalDate.parse(borrowDateStr, formatter);
                        
                        // Calculate days borrowed
                        long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(borrowDate, today);
                        
                        // Calculate days overdue (if any)
                        int allowedDays = item.getBorrowDuration();
                        long daysOverdue = Math.max(0, daysBorrowed - allowedDays);
                        
                        if (daysOverdue > 0) {
                            double dailyRate = getDailyRate(item);
                            totalFees += dailyRate * daysOverdue;
                        }
                    } catch (Exception e) {
                        logger.error("Error parsing borrow date: " + borrowDateStr + " for item: " + itemId, e);
                        // Continue with next item rather than failing completely
                    }
                } else {
                    logger.warn("No borrow date found for item: " + itemId + ", using today's date");
                    // Continue with next item rather than failing
                }
            }
        }
        
        logger.info("Late fees calculated for member " + memberId + ": $" + String.format("%.2f", totalFees));
        return totalFees;
    }
    
    private double getDailyRate(Item item) {
        if (item instanceof Book) {
            return 0.50; // $0.50 per day for books
        } else if (item instanceof Movie) {
            return 1.00; // $1.00 per day for movies
        } else if (item instanceof Magazine) {
            return 0.25; // $0.25 per day for magazines
        }
        return 0.0;
    }
    
    /**
     * Calculates late fees safely, returning 0.0 if there's an error
     * 
     * @param memberId The ID of the member to calculate fees for
     * @return The calculated late fees, or 0.0 if there was an error
     */
    public double calculateLateFeesSafely(String memberId) {
        try {
            return calculateLateFees(memberId);
        } catch (MemberNotFoundException e) {
            logger.warn("Safe late fee calculation returned 0.0 for member ID: " + memberId);
            return 0.0;
        }
    }
    
    // File I/O operations
    public void saveToCSV() throws IOException {
        logger.info("Starting data save operation");
        
        // Create data directory if it doesn't exist
        java.io.File dataDir = new java.io.File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
            logger.info("Created data directory");
        }
        
        try {
            // Save all items (unified format)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/items.csv"))) {
                writer.write("ID,Type,Title,Creator,Genre,Available,Extra1,Extra2");
                writer.newLine();
                
                for (Item item : items.values()) {
                    String extra1 = "", extra2 = "";
                    if (item instanceof Movie) {
                        Movie movie = (Movie) item;
                        extra1 = String.valueOf(movie.getDuration());
                    } else if (item instanceof Magazine) {
                        Magazine mag = (Magazine) item;
                        extra1 = mag.getIssueNumber();
                        extra2 = mag.getPublicationDate();
                    }
                    
                    writer.write(String.format("%s,%s,%s,%s,%s,%b,%s,%s",
                        item.getId(), item.getType(), item.getTitle(), 
                        item.getCreator(), item.getGenre(), item.isAvailable(),
                        extra1, extra2));
                    writer.newLine();
                }
            }
            
            // Save members
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/members.csv"))) {
                writer.write("MemberID,Name,Email");
                writer.newLine();
                
                for (Member member : members.values()) {
                    writer.write(String.format("%s,%s,%s",
                        member.getMemberId(), member.getName(), member.getEmail()));
                    writer.newLine();
                }
            }
            
            // Save borrowed items relationships
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/borrowed.csv"))) {
                writer.write("MemberID,ItemID,BorrowDate");
                writer.newLine();
                
                for (Member member : members.values()) {
                    Map<String, String> borrowDates = member.getBorrowDates();
                    for (String itemId : member.getBorrowedItems()) {
                        String borrowDate = borrowDates.getOrDefault(itemId, LocalDate.now().format(DateTimeFormatter.ISO_DATE));
                        writer.write(String.format("%s,%s,%s", member.getMemberId(), itemId, borrowDate));
                        writer.newLine();
                    }
                }
            }
            
            logger.info("Data save operation completed successfully");
        } catch (IOException e) {
            logger.error("Failed to save data", e);
            throw e;
        }
    }
    
    public void loadFromCSV() throws IOException {
        logger.info("Starting data load operation");
        
        // Create data directory if it doesn't exist
        java.io.File dataDir = new java.io.File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
            logger.info("Created data directory");
        }
        
        try {
            // Load all items from items.csv (primary source)
            File itemsFile = new File("data/items.csv");
            if (itemsFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(itemsFile))) {
                    String line = reader.readLine(); // Skip header
                    int itemCount = 0;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length >= 6) {
                            String id = parts[0];
                            String type = parts[1];
                            String title = parts[2];
                            String creator = parts[3];
                            String genre = parts[4];
                            boolean available = Boolean.parseBoolean(parts[5]);
                            
                            Item item = null;
                            if ("Book".equals(type)) {
                                item = new Book(id, title, creator, genre, available);
                            } else if ("Movie".equals(type) && parts.length >= 7) {
                                int duration = Integer.parseInt(parts[6]);
                                item = new Movie(id, title, creator, genre, duration, available);
                            } else if ("Magazine".equals(type) && parts.length >= 8) {
                                String issueNumber = parts[6];
                                String pubDate = parts.length > 7 ? parts[7] : "";
                                item = new Magazine(id, title, creator, genre, issueNumber, pubDate, available);
                            }
                            
                            if (item != null) {
                                items.put(id, item);
                                itemCount++;
                            }
                        }
                    }
                    logger.info("Loaded " + itemCount + " items from items.csv");
                }
            } else {
                logger.warn("items.csv not found. Please ensure the data directory contains this file.");
            }
            
            // Load members
            File membersFile = new File("data/members.csv");
            if (membersFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(membersFile))) {
                    String line = reader.readLine(); // Skip header
                    int memberCount = 0;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 3) {
                            Member member = new Member(parts[0], parts[1], parts[2]);
                            members.put(member.getMemberId(), member);
                            memberCount++;
                            // Update counter to prevent ID conflicts
                            if (parts[0].startsWith("M")) {
                                try {
                                    int id = Integer.parseInt(parts[0].substring(1));
                                    if (id >= memberCounter) {
                                        memberCounter = id;
                                    }
                                } catch (NumberFormatException e) {
                                    logger.warn("Malformed member ID: " + parts[0]);
                                }
                            }
                        }
                    }
                    logger.info("Loaded " + memberCount + " members from CSV");
                }
            }
            
            // Load borrowed items relationships
            File borrowedFile = new File("data/borrowed.csv");
            if (borrowedFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(borrowedFile))) {
                    String line = reader.readLine(); // Skip header
                    int borrowedCount = 0;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length >= 2) {
                            Member member = members.get(parts[0]);
                            String itemId = parts[1];
                            
                            if (member != null) {
                                // Add item to borrowed list
                                member.borrowItem(itemId);
                                
                                // Update borrow date if available
                                if (parts.length >= 3) {
                                    String borrowDateStr = parts[2];
                                    Map<String, String> borrowDates = member.getBorrowDates();
                                    
                                    // Use reflection to access private field (not ideal but works for demo)
                                    try {
                                        java.lang.reflect.Field field = Member.class.getDeclaredField("borrowDates");
                                        field.setAccessible(true);
                                        Map<String, String> memberBorrowDates = (Map<String, String>) field.get(member);
                                        memberBorrowDates.put(itemId, borrowDateStr);
                                    } catch (Exception e) {
                                        logger.error("Failed to set borrow date", e);
                                    }
                                }
                                borrowedCount++;
                            }
                        }
                    }
                    logger.info("Loaded " + borrowedCount + " borrowed item records from CSV");
                }
            }
            
            logger.info("Data load operation completed successfully");
        } catch (IOException e) {
            logger.error("Failed to load data", e);
            throw e;
        }
    }
    
    // Validation methods
    public static boolean isValidISBN(String isbn) {
        boolean valid = isbn != null && isbn.matches("\\d{10}|\\d{13}");
        if (!valid) {
            Logger.getInstance().warn("Invalid ISBN format: " + isbn);
        }
        return valid;
    }
    
    public static boolean isValidEmail(String email) {
        boolean valid = email != null && email.contains("@") && email.contains(".");
        if (!valid) {
            Logger.getInstance().warn("Invalid email format: " + email);
        }
        return valid;
    }
}