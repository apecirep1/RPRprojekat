module com.example.projekat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projekat to javafx.fxml;
    exports com.example.projekat;
    exports com.example.projekat.controller;
    opens com.example.projekat.controller to javafx.fxml;
}