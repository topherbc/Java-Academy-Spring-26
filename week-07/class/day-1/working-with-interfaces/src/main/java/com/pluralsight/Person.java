package com.pluralsight;

public class Person implements Comparable<Person> {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        //return -1 if this lastname is sorted before next?
        //return 0 if they're the same
        //return 1 if next lastname is sorted after this
        if (this.lastName.compareTo(o.lastName) != 0) {
            return this.lastName.compareTo(o.lastName);
        } else if (this.firstName.compareTo(o.firstName) != 0) {
            return this.firstName.compareTo(o.firstName);
        }

        return Integer.compare(this.age, o.age);


//        if (this.lastName.compareTo(o.lastName) == 0) {
//            if (this.firstName.compareTo(o.firstName) == 0) {
//                if (Integer.compare(this.age, o.age) == 0) {
//                    return 0;
//                } else {
//                    return Integer.compare(this.age, o.age);
//                }
//            } else {
//                return this.firstName.compareTo(o.firstName);
//            }
//        } else {
//            return this.lastName.compareTo(o.lastName);
//        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
