package com.pluralsight;

public class CellPhone {
    //private or public == Access Modifiers/Specifiers
    private int serialNumber;
    private String phoneNumber, owner, model, carrier;

    //Constructor method
    public CellPhone() { //parameterless
        this.serialNumber = 0;
        this.phoneNumber = "NO PHONE NUMBER AVAILABLE";
        this.owner = "";
        this.model = "";
        this.carrier = "";
    }

    public CellPhone(int serialNumber, String phoneNumber, String owner, String model, String carrier) {
        this.serialNumber = serialNumber;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.model = model;
        this.carrier = carrier;
    }

    public void dial(String phoneNumber) {
        System.out.println(this.owner + "'s phone is calling " + phoneNumber);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
