package edu.oakland.csi3450.service;

import java.util.List;
import java.util.Date;
import edu.oakland.csi3450.models.*;

public interface IDB {
    List<Aircraft> getAircrafts();
    List<Aircraft> getAircrafts(String limit);
    List<String> getColNames(String name);
    List<String> getDataTypes(String name);
    List<String> getTableNames();
    List<Flight> getFlights();
    List<Flight> getFlights(String limit);
    List<Flight> getFlights(String arriving, String departing);
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
    List<Reservation> getReservations();
    List<Reservation> getReservations(String limit);
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
    int insertFlight(String flightNumber, int terminalNumber, String gate, int routing,
        String arrival, String departing, int availability, String status, Double cost);
    int insertAircraft(double capacity, String flightNumber, double routing_range, String name);
    int insertEmployee(String aircraftID, String airportID, String jobID, String firstName,
        String lastName, Date dateHired);
    int insertContact(
        String firstName, String lastName, Double phoneNumber, String email, String relationship);
    int insertJob(String type, Double salary);
    int insertPayment(String vendorName, int vendorID, String method);
    int insertReservation(int luggageWeight, int seatNumber, String accommodations,
        String aircraftID, String invoiceID, Boolean insurance);
    int insertCancellation(String reservationID, Date cancelDate);
    int insertPlaneService(String movie, String wifi, String meal);
    int insertCustomer(String firstName, String lastName, String email, Boolean passport,
        String street, String city, String state, String country, String contactID,
        String reservationID);
    int insertMembership(Double discount, String customerID, String type);
    int updateAirport(
        String airportID, String airportName, String airportCity, String airportCountry);
    int updateFlight(String flightNumber, int terminalNumber, String gate, int routing,
        String arrival, String departing, int availability, String status, Double cost);
    int updateAircraft(
        String aircraftID, double capacity, String flightNumber, double routing_range, String name);
    int updateEmployee(String employeeID, String aircraftID, String airportID, String jobID,
        String firstName, String lastName, Date dateHired);
    int updateContact(String contactID, String firstName, String lastName, Double phoneNumber,
        String email, String relationship);
    int updateJob(String jobID, String type, Double salary);
    int updatePayment(String invoiceID, String vendorName, int vendorID, String method);
    int updateReservation(String reservationID, int luggageWeight, int seatNumber,
        String accommodations, String aircraftID, String invoiceID, Boolean insurance);
    int updateCancellation(String reservationID, Date cancelDate);
    int updatePlaneService(String serviceID, String movie, String wifi, String meal);
    int updateCustomer(String customerID, String firstName, String lastName, String email,
        Boolean passport, String street, String city, String state, String country,
        String contactID, String reservationID);
    int updateMembership(String membershipID, Double discount, String customerID, String type);
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
