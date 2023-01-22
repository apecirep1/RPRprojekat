package com.example.projekat.model;

public class Reservation {
    private String dateOfArrival;
    private String departureDate;
    private String reservationName;
    private String roomType;
    private int roomNumber;
    private int pricePerNight;
    public Reservation(){

    }

    public Reservation(String dateOfArrival, String departureDate, String reservationName, String roomType, int roomNumber, int pricePerNight) {
        this.dateOfArrival = dateOfArrival;
        this.departureDate = departureDate;
        this.reservationName = reservationName;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
