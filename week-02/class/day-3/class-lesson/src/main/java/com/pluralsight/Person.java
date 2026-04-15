package com.pluralsight;

public class Person {
    private String name;
    private int age;
    private String hobby;

    //A constructor method
    //instantiate
    public Person(String name, int age, String hobby) {
        //this <- referring to the instance
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getHobby(String message) {
        return this.name + " Loves to do: " + hobby + " " + message;
    }

    //Overloading == the same method, with different signatures
    //Accepts different parameters, but the name of return type stays the same
    public String getHobby(int count) {
        return this.name + " Loves to do: " + hobby + " " + count;
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
