package com.pluralsight.model.valueobjects;

/**
 * Immutable value object representing contact details for a library member.
 * Contains personal information such as name, email, phone, and address.
 * Used to transfer member contact details without exposing the full member entity.
 * 
 * @author Library Management System Team
 * @version 1.0
 */
public class MemberContact {
    private final String name;
    private final String email;
    private final String phone;
    private final String address;
    
    public MemberContact(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    
    @Override
    public String toString() {
        return String.format("MemberContact[name=%s, email=%s, phone=%s, address=%s]",
            name, email, phone, address);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MemberContact that = (MemberContact) obj;
        return name.equals(that.name) && 
               email.equals(that.email) &&
               (phone == null ? that.phone == null : phone.equals(that.phone)) &&
               (address == null ? that.address == null : address.equals(that.address));
    }
    
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}