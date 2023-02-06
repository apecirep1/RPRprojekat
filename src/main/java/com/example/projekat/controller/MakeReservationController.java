package com.example.projekat.controller;

import com.example.projekat.model.HotelDAO;
import com.example.projekat.model.Reservation;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MakeReservationController {
    public TextField nameOfReservation;
    public TextField dateOfArrival;
    public TextField departureDate;
    public TextField roomNumber;
    public TextField pricePerNight;
    public CheckBox singleBed;
    public CheckBox doubleBed;
    public CheckBox tripleBed;
    public Button ok;

    private HotelDAO dao;

    public MakeReservationController() {
    }

    public void actionOk(ActionEvent actionEvent){
        String name = nameOfReservation.getText();
        String dateArrival = dateOfArrival.getText();
        String dateDeparture = departureDate.getText();
        String type="";
        if(singleBed.isSelected()){
            type="single bed";
        }else if(doubleBed.isSelected()){
            type = "double bed";
        }else if(tripleBed.isSelected()){
            type = "triple bed";
        }

        int roomnmb = Integer.parseInt(roomNumber.getText());

        int price = Integer.parseInt(pricePerNight.getText());

        Reservation reservation = new Reservation(dateArrival, dateDeparture, name, type, roomnmb, price);
        dao.addReservation(reservation);
    }



}
