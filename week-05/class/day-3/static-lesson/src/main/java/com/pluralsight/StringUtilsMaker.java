package com.pluralsight;

public class StringUtilsMaker {

    public final String DEFAULT_GREETING = "Hello";

    public String greet(String name) {
        return String.format("%s, %s!", DEFAULT_GREETING, name);
    }

    public String alert(String text) {
        return String.format("ALERT: %s", text);
    }

    public void outputSpacingFormat() {
        System.out.println("\n\n\n\n\n");
    }

    public boolean isPalindrome(String text) {
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
