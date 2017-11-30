package edu.oakland.csi3450.service;

import java.util.List;
import edu.oakland.csi3450.models.*;

public interface IDB {
    List<Aircraft> getAircrafts();
    List<Flight> getFlights();
    List<Airport> getAirports();
    List<String> getAirportIDs();
    List<Employee> getEmployees();
    List<Contact> getContacts();
    List<Job> getJobs();
    List<Payment> getPayments();
    List<Reservation> getReservations();
    List<Cancellation> getCancellations();
    List<Service> getServices();
    List<Customer> getCustomer();
    List<Membership> getMemberships();
}
