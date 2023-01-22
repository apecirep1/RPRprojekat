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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberOfID() {
        return numberOfID;
    }

    public void setNumberOfID(String numberOfID) {
        this.numberOfID = numberOfID;
    }
}
