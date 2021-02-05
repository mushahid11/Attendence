package com.example.attendence;

public class dataHolder {
    String name;
    String email;
    String password;
    String Contact;
    String designation;
    String currentAdress;
    String perminentAddress;

    public dataHolder() {
    }

    public dataHolder(String name, String email, String password, String contact, String designation, String currentAdress, String perminentAddress) {
        this.name = name;
        this.email = email;
        this.password = password;
        Contact = contact;
        this.designation = designation;
        this.currentAdress = currentAdress;
        this.perminentAddress = perminentAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCurrentAdress() {
        return currentAdress;
    }

    public void setCurrentAdress(String currentAdress) {
        this.currentAdress = currentAdress;
    }

    public String getPerminentAddress() {
        return perminentAddress;
    }

    public void setPerminentAddress(String perminentAddress) {
        this.perminentAddress = perminentAddress;
    }
}
