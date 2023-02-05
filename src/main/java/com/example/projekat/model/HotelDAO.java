package com.example.projekat.model;


import java.sql.*;


public class HotelDAO {
    private static HotelDAO instance;
    private Connection conn;

    private PreparedStatement getGuestQuery, deleteGuestQuery, getReservationQuery, deleteReservationQuery,
            getWorkerQuery, deleteWorkerQuery, getcityForGuestQuery, getCountryForGuestQuery, getNumberOfIdForGuestQuery,
            getDateOfArrivalQuery, getDepartureDateQuery, getRoomTypeQuery, getRoomNumberQuery, getPricePerNightQuery,
            getTypeOfWorkQuery, addReservationQuery, addGuestQuery, addWorkerQuery, changeReservationQuery;

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
            getNumberOfIdForGuestQuery = conn.prepareStatement("SELECT gosti.brojLicneKarte FROM gosti WHERE ime=?");
            getDateOfArrivalQuery = conn.prepareStatement("SELECT rezervacije.datumDolaska FROM rezervacije WHERE imeRezervacije=?");
            getDepartureDateQuery = conn.prepareStatement("SELECT rezervacije.datumOdlaska FROM rezervacije WHERE imeRezervacije=?");
            getRoomTypeQuery = conn.prepareStatement("SELECT rezervacije.vrstaSobe FROM rezervacije WHERE imeRezervacije=?");
            getRoomNumberQuery = conn.prepareStatement("SELECT rezervacije.brojSobe FROM rezervacije WHERE imeRezervacije=?");
            getPricePerNightQuery = conn.prepareStatement("SELECT rezervacije.cijenaNocenja FROM rezervacije WHERE imeRezervacije=?");
            getTypeOfWorkQuery = conn.prepareStatement("SELECT radnici.vrstaPosla FROM radnici WHERE ime=?");

            addReservationQuery = conn.prepareStatement("INSERT INTO rezervacije VALUES(?,?,?,?,?,?)");
            addGuestQuery = conn.prepareStatement("INSERT INTO gosti VALUES(?,?,?,?,?)");
            addWorkerQuery = conn.prepareStatement("INSERT INTO gosti VALUES(?,?,?)");

            changeReservationQuery =conn.prepareStatement("UPDATE rezervacije SET datumDolaska=?, datumOdlaska=?, imeRezervacije=?, vrstaSobe=?, brojSobe=?, cijenaNocenja=? WHERE imeRezervacije=?");
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

    private Guest getGuestFromResultSet(ResultSet rs) throws SQLException {
        Guest guest = new Guest(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        return guest;
    }

    private Worker getWorkerFromResultSet(ResultSet rs) throws SQLException {
        Worker worker = new Worker(rs.getString(1), rs.getString(2), rs.getString(3));
        return worker;
    }

    private Reservation getReservationFromResultSet(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
        return reservation;
    }

}
