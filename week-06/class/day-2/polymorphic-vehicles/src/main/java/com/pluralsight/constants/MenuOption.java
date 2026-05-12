package com.pluralsight.constants;

/**
 * Constants for menu options in the VIS application.
 * Defines numeric values for each menu choice and valid option ranges.
 */
public class MenuOption {
    public static final int CAR = 1;
    public static final int MOPED = 2;
    public static final int SEMI_TRUCK = 3;
    public static final int HOVERCRAFT = 4;
    public static final int DISPLAY_ALL = 5;
    public static final int SEARCH = 6;
    public static final int ADD_VEHICLE = 7;
    public static final int EXIT = 8;

    public static final int MIN_OPTION = CAR;
    public static final int MAX_OPTION = EXIT;

    /**
     * Private constructor to prevent instantiation.
     */
    private MenuOption() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}