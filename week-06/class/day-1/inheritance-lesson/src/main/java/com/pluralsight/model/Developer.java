package com.pluralsight.model;

public class Developer extends Employee {
    private boolean serverAccess;
    private String programmingLanguage;

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
                ", ssn='" + ssn + '\'' +
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
