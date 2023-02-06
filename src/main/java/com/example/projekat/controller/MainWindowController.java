package com.example.projekat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class MainWindowController {
    public Button makeReservation;
    public Button deleteReservation;
    public Button changeReservation;
    public Button exit;
    public ChoiceBox moreOptions;
    public TextField fieldSearch;
    public Button search;

    public MainWindowController() {
    }

    public void actionMakeReservation(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/makeReservation.fxml"));
            MakeReservationController makeReservationController = new MakeReservationController();
            loader.setController(makeReservationController);
            root = loader.load();
            stage.setTitle("Make Reservation");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionDeleteReservation(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/deleteReservation.fxml"));
            DeleteReservationController deleteReservationController = new DeleteReservationController();
            loader.setController(deleteReservationController);
            root = loader.load();
            stage.setTitle("Delete Reservation");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionChangeReservation(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/changeReservation.fxml"));
            ChangeReservationController changeReservationController = new ChangeReservationController();
            loader.setController(changeReservationController);
            root = loader.load();
            stage.setTitle("Change Reservation");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionSearch(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/searchReservation.fxml"));
            SearchReservationController searchReservationController = new SearchReservationController();
            loader.setController(searchReservationController);
            root = loader.load();
            stage.setTitle("Search Reservation");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionExit(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/exitForm.fxml"));
            ExitFormController exitFormController = new ExitFormController();
            loader.setController(exitFormController);
            root = loader.load();
            stage.setTitle("Exit");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
