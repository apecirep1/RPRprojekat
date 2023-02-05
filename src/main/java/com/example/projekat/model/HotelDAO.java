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
