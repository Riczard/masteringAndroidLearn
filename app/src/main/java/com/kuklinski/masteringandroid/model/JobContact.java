package com.kuklinski.masteringandroid.model;

public class JobContact {

    private String name;
    private String description;
    private String country;
    private String email;

    public JobContact() {
    }

    public JobContact(String name, String description, String country, String email) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }
}
