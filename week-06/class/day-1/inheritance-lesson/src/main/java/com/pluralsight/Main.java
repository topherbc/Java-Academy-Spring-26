package com.pluralsight;

import com.pluralsight.model.*;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Polina");
        e1.setSalary(100000);
        e1.work();

        Manager m1 = new Manager();
        m1.setId(2);
        m1.setName("Bryan");
        m1.setSalary(200000);
        m1.setTeamSize(2);
        m1.work();

        Developer d1 = new Developer();
        d1.setId(3);
        d1.setName("Jihad");
        d1.setSalary(300000);
        d1.setProgrammingLanguage("Java");
        d1.work();

    }
}
