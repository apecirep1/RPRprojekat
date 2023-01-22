package com.example.projekat.model;

public class Guest {
    private String name;
    private String lastName;
    private String city;
    private String country;
    private String numberOfID;

    public Guest(){

    }

    public Guest(String name, String lastName, String city, String country, String numberOfID) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.numberOfID = numberOfID;
    }
}
