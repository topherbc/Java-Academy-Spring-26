package com.pluralsight;

public class Person {
    private String name;
    private int age;
    private String hobby;

    //A constructor method
    //instantiate
    public Person(String name, int age, String hobby) {
        //this <- refering to the instance
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getHobby() {
        return this.name + " Loves to do: " + hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
