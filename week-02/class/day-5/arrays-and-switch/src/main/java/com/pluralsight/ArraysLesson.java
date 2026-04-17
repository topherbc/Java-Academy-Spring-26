package com.pluralsight;

public class ArraysLesson {
    public static void main(String[] args) {

        //Arrays
        //Basic data type Array

        //Arrays are fixed in type
        //Arrays are fixed in size

        //Arrays have elements with positions
        //Positions are referred to as index
        //Index start counting at 0

        String[] hedgehogNames = {"Sonic", "Shadow", "Mario", "Henry", "Chris P Bacon", "Silver", "Glenda", "Tony", "Sasha", "Amy", "Larry", "Irish"};

        int randHedgeNum = (int) (Math.random() * hedgehogNames.length-1) + 0;
        System.out.println(hedgehogNames[randHedgeNum] + " the Hedgehog");
//        System.out.println(hedgehogNames[-1]);
    }
}
