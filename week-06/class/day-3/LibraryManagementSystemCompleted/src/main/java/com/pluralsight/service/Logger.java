package com.pluralsight.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger for the Library Management System.
 * Implements the Singleton pattern and handles log rotation.
 * Supports different log levels and formats exception stack traces.
 * 
 * @author Library Management System Team
 * @version 1.1
 */
public class Logger {
    private static final String LOG_DIR = "logs";
    private static final String BASE_LOG_FILE = "library.log";
    private static final int MAX_LOG_SIZE_KB = 1024; // 1 MB before rotation
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FILE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    
    private static Logger instance;
    private PrintWriter logWriter;
    private String currentLogFile;
    private java.io.File logFileObj;
    private boolean debugEnabled = true; // Can be set via configuration
    
    private Logger() {
        try {
            // Create logs directory if it doesn't exist
            java.io.File logDir = new java.io.File(LOG_DIR);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }
            
            // Set current log file
            currentLogFile = LOG_DIR + "/" + BASE_LOG_FILE;
            logFileObj = new java.io.File(currentLogFile);
            
            // Check if rotation is needed
            if (logFileObj.exists() && logFileObj.length() > MAX_LOG_SIZE_KB * 1024) {
                rotateLogFile();
            }
            
            // Initialize log writer with append mode
            logWriter = new PrintWriter(new FileWriter(currentLogFile, true));
            
            // Log system startup
            info("Logger initialized. System startup.");
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }
    
    /**
     * Rotates log file by renaming the current file with a timestamp
     * and creates a new log file.
     */
    private void rotateLogFile() throws IOException {
        if (logWriter != null) {
            logWriter.close();
        }
        
        String timestamp = LocalDateTime.now().format(FILE_DATE_FORMAT);
        String rotatedFile = LOG_DIR + "/library-" + timestamp + ".log";
        
        java.io.File currentFile = new java.io.File(currentLogFile);
        if (currentFile.renameTo(new java.io.File(rotatedFile))) {
            System.out.println("Log rotated to: " + rotatedFile);
        } else {
            System.err.println("Failed to rotate log file");
        }
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    private void log(String level, String message) {
        if (logWriter != null) {
            String timestamp = LocalDateTime.now().format(DATE_FORMAT);
            String logEntry = String.format("[%s] %s - %s", timestamp, level, message);
            logWriter.println(logEntry);
            logWriter.flush(); // Ensure immediate write to file
        }
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
        System.err.println("ERROR: " + message); // Also print to console
    }
    
    /**
     * Logs an error message with full exception details
     * 
     * @param message The error message
     * @param e The exception that occurred
     */
    public void error(String message, Exception e) {
        log("ERROR", message + " - " + e.getMessage());
        System.err.println("ERROR: " + message + " - " + e.getMessage());
        
        if (logWriter != null) {
            // Log full stack trace
            logWriter.println("==== Exception Stack Trace ====");
            e.printStackTrace(logWriter);
            
            // Log cause if available
            Throwable cause = e.getCause();
            if (cause != null) {
                logWriter.println("==== Caused By ====");
                cause.printStackTrace(logWriter);
            }
            
            // Log exception class hierarchy for easier debugging
            logWriter.println("==== Exception Hierarchy ====");
            Class<?> exClass = e.getClass();
            while (exClass != null) {
                logWriter.println("  " + exClass.getName());
                exClass = exClass.getSuperclass();
            }
            
            logWriter.println("============================");
            logWriter.flush();
        }
    }
    
    public void warn(String message) {
        log("WARN", message);
    }
    
    /**
     * Logs a debug message if debug logging is enabled
     * 
     * @param message The debug message
     */
    public void debug(String message) {
        if (debugEnabled) {
            log("DEBUG", message);
        }
    }
    
    /**
     * Logs a debug message with exception details if debug logging is enabled
     * 
     * @param message The debug message
     * @param e The exception to log
     */
    public void debug(String message, Exception e) {
        if (debugEnabled) {
            log("DEBUG", message + " - " + e.getMessage());
            if (logWriter != null) {
                e.printStackTrace(logWriter);
                logWriter.flush();
            }
        }
    }
    
    /**
     * Enables or disables debug logging
     * 
     * @param enable True to enable debug logging, false to disable
     */
    public void setDebugEnabled(boolean enable) {
        this.debugEnabled = enable;
        if (enable) {
            info("Debug logging enabled");
        } else {
            info("Debug logging disabled");
        }
    }
    
    public void close() {
        if (logWriter != null) {
            logWriter.close();
        }
    }
    
    // Add shutdown hook to close logger properly
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (instance != null) {
                instance.close();
            }
        }));
    }
}