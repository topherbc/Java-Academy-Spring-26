package com.pluralsight.constants;

/**
 * Constants for add vehicle menu options in the VIS application.
 * Defines vehicle types that can be added to inventory.
 */
public class AddOption {
    public static final int CAR = 1;
    public static final int MOPED = 2;
    public static final int SEMI_TRUCK = 3;
    public static final int HOVERCRAFT = 4;
    public static final int BACK = 5;

    public static final int MIN_OPTION = CAR;
    public static final int MAX_OPTION = BACK;

    /**
     * Private constructor to prevent instantiation.
     */
    private AddOption() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}