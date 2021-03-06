package edu.oakland.csi3450.service;

import java.util.List;
import edu.oakland.csi3450.models.*;

public interface IDB {
    List<Aircraft> getAircrafts();
    List<Aircraft> getAircrafts(String limit);
    Aircraft getAircraft(String key);
    List<String> getColNames(String name);
    List<String> getDataTypes(String name);
    List<String> getTableNames();
    List<Flight> getFlights();
    List<Flight> getFlights(String limit);
    List<Flight> getFlights(String arriving, String departing);
    Flight getFlight(String key);
    List<Airport> getAirports();
    List<Airport> getAirports(String limit);
    List<String> getAirportIDs();
    List<Employee> getEmployees();
    List<Employee> getEmployees(String limit);
    List<Contact> getContacts();
    List<Contact> getContacts(String limit);
    List<Job> getJobs();
    List<Job> getJobs(String limit);
    List<Payment> getPayments();
    List<Payment> getPayments(String payment);
    Payment getLatestPayment();
    List<Reservation> getReservations();
    List<Reservation> getReservations(String limit);
    List<Reservation> getReservationsForFlight(String flightNumber);
    List<Cancellation> getCancellations();
    List<Cancellation> getCancellations(String limit);
    List<PlaneService> getPlaneServices();
    List<PlaneService> getPlaneServices(String limit);
    List<Customer> getCustomers();
    List<Customer> getCustomers(String limit);
    List<Membership> getMemberships();
    List<Membership> getMemberships(String limit);
    int insertAirport(
        String airportID, String airportName, String airportCity, String airportCountry);
    int insertFlight(int aircraftID, int terminalNumber, String gate, int routing, String arrival,
        String departing, int availability, String status, Double cost, String departTime,
        String arrivalTime);
    int insertAircraft(double capacity, double routing_range, String name);
    int insertEmployee(String flightNumber, String airportID, String jobID, String firstName,
        String lastName, String dateHired);
    int insertContact(
        String firstName, String lastName, String phoneNumber, String email, String relationship);
    int insertJob(String type, Double salary);
    int insertPayment(
        String vendorName, String csv, String method, String card_number, Double cost);
    int insertReservation(int seatNumber, String accommodations, String aircraftID,
        String invoiceID, Boolean insurance);
    int insertCancellation(String reservationID, String cancelDate);
    int insertPlaneService(String movie, String wifi, String meal);
    int insertCustomer(String firstName, String lastName, String email, Boolean passport,
        String street, String city, String state, String country, String contactID,
        String reservationID);
    int insertMembership(Double discount, String type);
    int updateAirport(
        String airportID, String airportName, String airportCity, String airportCountry);
    int updateFlight(String flightNumber, int aircraftID, int terminalNumber, String gate,
        int routing, String arrival, String departing, int availability, String status, Double cost,
        String arrivalTime, String departTime);
    int updateAircraft(String aircraftID, double capacity, double routing_range, String name);
    int updateEmployee(String employeeID, String flightNumber, String airportID, String jobID,
        String firstName, String lastName, String dateHired);
    int updateContact(String contactID, String firstName, String lastName, String phoneNumber,
        String email, String relationship);
    int updateJob(String jobID, String type, Double salary);
    int updatePayment(String invoiceID, String vendorName, int vendorID, String method);
    int updateReservation(String reservationID, int seatNumber, String accommodations,
        String aircraftID, String invoiceID, Boolean insurance);
    int updateCancellation(String reservationID, String cancelDate);
    int updatePlaneService(String serviceID, String movie, String wifi, String meal);
    int updateCustomer(String customerID, String firstName, String lastName, String email,
        Boolean passport, String street, String city, String state, String country,
        String contactID, String reservationID);
    int updateMembership(String membershipID, Double discount, String type);
    int deleteAirport(String key);
    int deleteFlight(String key);
    int deleteAircraft(String key);
    int deleteEmployee(String key);
    int deleteContact(String key);
    int deleteJob(String key);
    int deletePayment(String key);
    int deleteReservation(String key);
    int deleteCancellation(String key);
    int deletePlaneService(String key);
    int deleteCustomer(String key);
    int deleteMembership(String key);
}
