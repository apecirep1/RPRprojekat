package com.example.projekat.model;


import java.sql.*;


public class HotelDAO {
    private static HotelDAO instance;
    private Connection conn;

    private PreparedStatement getGuestQuery, deleteGuestQuery, getReservationQuery, deleteReservationQuery,
            getWorkerQuery, deleteWorkerQuery, getcityForGuestQuery, getCountryForGuestQuery, getNumberOfIdForGuestQuery,
            getDateOfArrivalQuery, getDepartureDateQuery, getRoomTypeQuery, getRoomNumberQuery, getPricePerNightQuery,
            getTypeOfWorkQuery;

    public static HotelDAO getInstance() {
        if (instance == null) instance = new HotelDAO();
        return instance;
    }

    private HotelDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:mydb.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            getGuestQuery = conn.prepareStatement("SELECT * FROM gosti WHERE ime=?");
            deleteGuestQuery = conn.prepareStatement("DELETE FROM gosti WHERE ime=?");
            getReservationQuery = conn.prepareStatement("SELECT * FROM rezervacije WHERE ime=?");
            deleteReservationQuery = conn.prepareStatement("DELETE FROM rezervacije WHERE ime=?");
            getWorkerQuery = conn.prepareStatement("SELECT * FROM radnici WHERE ime=?");
            deleteWorkerQuery = conn.prepareStatement("DELETE FROM radnici WHERE ime=?");
            getcityForGuestQuery = conn.prepareStatement("SELECT gosti.grad FROM gosti WHERE ime=?");
            getCountryForGuestQuery = conn.prepareStatement("SELECT gosti.drzava FROM gosti WHERE ime=?");
            getNumberOfIdForGuestQuery = conn.prepareStatement("SELECT gosti.broj licne karte FROM gosti WHERE ime=?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
