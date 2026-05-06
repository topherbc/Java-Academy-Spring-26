package com.pluralsight;

public class StringUtils {

    public static final String DEFAULT_GREETING = "Hello";

    public static String greet(String name) {
        return String.format("%s, %s!", DEFAULT_GREETING, name);
    }

    public static String alert(String text) {
        return String.format("ALERT: %s", text);
    }

    public static void outputSpacingFormat() {
        System.out.println("\n\n\n\n\n");
    }

    public static boolean isPalindrome(String text) {
        String lower = text.toLowerCase();
        int left = 0;
        int right = lower.length() - 1;
        while (left < right) {
            if (lower.charAt(left) != lower.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
