package com.example.workshopmanagementapp.model.web;

public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String emial;
    private String password;

    public UserRegistrationDTO(String firstName, String lastName, String emial, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emial = emial;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
