package com.pluralsight;

import com.pluralsight.model.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Polina", 1, 100000);
        e1.work();

        Manager m1 = new Manager("Bryan", 2, 200000, 2);
        m1.work();

        Developer d1 = new Developer("Jihad", 3, 300000, "Java");
        d1.work();
    }
}
