package com.example.projekat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public Button pict;
    public RadioButton addWorker;
    public RadioButton deleteWorker;
    public Button ok;

    public MainWindowController() {
    }


    @FXML
    public void initialize(){
        Image img1 = new Image("/pictures/hotel.png");
        ImageView view1 = new ImageView(img1);
        view1.setFitHeight(159);
        view1.setFitWidth(232);
        pict.setGraphic(view1);

        if(addWorker.isSelected()){
            deleteWorker.setSelected(false);
        }

        if(deleteWorker.isSelected()){
            addWorker.setSelected(false);
        }
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

    public void actionOk(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        if(addWorker.isSelected()){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/addWorker.fxml"));
                AddWorkerController addWorkerController = new AddWorkerController();
                loader.setController(addWorkerController);
                root = loader.load();
                stage.setTitle("Add Worker");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/deleteWorker.fxml"));
                DeleteWorkerController deleteWorkerController = new DeleteWorkerController();
                loader.setController(deleteWorkerController);
                root = loader.load();
                stage.setTitle("Delete Worker");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
