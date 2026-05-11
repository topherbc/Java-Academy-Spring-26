package com.pluralsight.model;

public class Developer extends Employee {
    private boolean serverAccess;
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println("Developer " + this.name + " is programming in " + this.programmingLanguage);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public boolean hasServerAccess() {
        return serverAccess;
    }

    public void setServerAccess(boolean serverAccess) {
        this.serverAccess = serverAccess;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
