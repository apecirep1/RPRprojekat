package com.example.projekat.model;

public class Worker {
    private String name;
    private String lastName;
    private String typeOfWork;

    public Worker(){

    }

    public Worker(String name, String lastName, String typeOfWork) {
        this.name = name;
        this.lastName = lastName;
        this.typeOfWork = typeOfWork;
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

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }
}
