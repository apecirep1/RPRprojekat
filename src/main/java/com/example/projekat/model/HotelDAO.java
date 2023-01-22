package com.example.projekat.model;


import java.sql.*;


public class HotelDAO {
    private static HotelDAO instance;
    private Connection conn;

    public static HotelDAO getInstance() {
        if (instance == null) instance = new HotelDAO();
        return instance;
    }

    private GeografijaDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
