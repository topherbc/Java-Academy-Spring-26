package com.pluralsight;

import com.pluralsight.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("Polina", 1, 100000);
        employees.add(e1);

        Manager m1 = new Manager("Bryan", 2, 200000, 2);
        employees.add(m1);

        Developer d1 = new Developer("Jihad", 3, 300000, "Java");
        employees.add(d1);

        for (Employee e : employees) {
            e.work();
        }
    }
}
