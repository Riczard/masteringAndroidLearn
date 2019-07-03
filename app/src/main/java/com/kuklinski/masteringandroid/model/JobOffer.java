package com.kuklinski.masteringandroid.model;

public class JobOffer {

    private String id;
    private String tittle;
    private String description;
    private String type;
    private String salary;
    private String company;
    private String imageLink;
    private String location;

    public JobOffer() {
    }

    public JobOffer(String id, String tittle, String description, String type, String salary, String company, String imageLink, String location) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.type = type;
        this.salary = salary;
        this.company = company;
        this.imageLink = imageLink;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLocation() {
        return location;
    }
}
