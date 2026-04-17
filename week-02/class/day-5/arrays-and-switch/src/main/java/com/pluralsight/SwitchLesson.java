package com.pluralsight;

public class SwitchLesson {
    public static void main(String[] args) {

        int x = 99;

        switch (x) {
            case 1:
                System.out.println("Case 1 found");
                break;
            case 2:
                System.out.println("Case 2 found");
                break;
            case 5:
                System.out.println("Case 5 found");
                break;
            default:
                System.out.println("No case found");
                break;
        }

    }
}
