package com.pluralsight.constants;

/**
 * Constants for search menu options in the VIS application.
 * Defines search criteria available to users.
 */
public class SearchOption {
    public static final int COLOR = 1;
    public static final int TYPE = 2;
    public static final int MAKE = 3;
    public static final int PASSENGER_COUNT = 4;
    public static final int BACK = 5;

    public static final int MIN_OPTION = COLOR;
    public static final int MAX_OPTION = BACK;

    /**
     * Private constructor to prevent instantiation.
     */
    private SearchOption() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}