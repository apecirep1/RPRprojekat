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
            getReservationQuery = conn.prepareStatement("SELECT * FROM rezervacije WHERE imeRezervacije=?");
            deleteReservationQuery = conn.prepareStatement("DELETE FROM rezervacije WHERE imeRezervacije=?");
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
            addWorkerQuery = conn.prepareStatement("INSERT INTO radnici VALUES(?,?,?)");

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

    public void deleteWorker(Worker worker) {
        try {
            deleteWorkerQuery.setString(1, worker.getName());
            deleteWorkerQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGuest(Guest guest) {
        try {
            deleteGuestQuery.setString(1, guest.getName());
            deleteGuestQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(Reservation reservation) {
        try {
            deleteReservationQuery.setString(1, reservation.getReservationName());
            deleteReservationQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addWorker(Worker worker) {
        try {

            addWorkerQuery.setString(1, worker.getName());
            addWorkerQuery.setString(2, worker.getLastName());
            addWorkerQuery.setString(3, worker.getTypeOfWork());
            addWorkerQuery.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGuest(Guest guest) {
        try {

            addGuestQuery.setString(1, guest.getName());
            addGuestQuery.setString(2, guest.getLastName());
            addGuestQuery.setString(3, guest.getCity());
            addGuestQuery.setString(4, guest.getCountry());
            addGuestQuery.setString(5, guest.getNumberOfID());
            addGuestQuery.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addReservation(Reservation reservation){
        try {
            addReservationQuery.setString(1, reservation.getDateOfArrival());
            addReservationQuery.setString(2, reservation.getDepartureDate());
            addReservationQuery.setString(3, reservation.getReservationName());
            addReservationQuery.setString(4, reservation.getRoomType());
            addReservationQuery.setInt(5, reservation.getRoomNumber());
            addReservationQuery.setInt(6, reservation.getPricePerNight());
            addReservationQuery.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeReservation(Reservation reservation) {
        try {
            changeReservationQuery.setString(1, reservation.getDateOfArrival());
            changeReservationQuery.setString(2, reservation.getDepartureDate());
            changeReservationQuery.setString(3, reservation.getReservationName());
            changeReservationQuery.setString(4, reservation.getRoomType());
            changeReservationQuery.setInt(5, reservation.getRoomNumber());
            changeReservationQuery.setInt(6, reservation.getPricePerNight());
            changeReservationQuery.setString(7,reservation.getReservationName());
            changeReservationQuery.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
