package edu.oakland.csi3450.service;

import edu.oakland.csi3450.models.*;
import edu.oakland.csi3450.service.*;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.jdbc.core.namedparam.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Service
public class DB implements IDB {
    @Autowired private JdbcTemplate jdbcTemplate;

    public List<String> getColNames(String name) {
        try {
            List<String> names = jdbcTemplate.queryForList(
                Constants.GET_COL_NAMES, new Object[] {name}, String.class);
            return names;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> getDataTypes(String name) {
        try {
            List<String> types = jdbcTemplate.queryForList(
                Constants.GET_DATA_TYPES, new Object[] {name}, String.class);
            return types;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> getTableNames() {
        try {
            List<String> names = jdbcTemplate.queryForList(Constants.GET_TABLE_NAMES, String.class);
            return names;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Aircraft> getAircrafts() {
        try {
            List<Aircraft> aircrafts = new ArrayList<Aircraft>();
            aircrafts.addAll(
                jdbcTemplate.query(Constants.GET_AIRCRAFTS, new Object[] {}, aircraftMapper));
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Aircraft> getAircrafts(String limit) {
        try {
            List<Aircraft> aircrafts = new ArrayList<Aircraft>();
            aircrafts.addAll(jdbcTemplate.query(Constants.GET_AIRCRAFTS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, aircraftMapper));
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }

    public Aircraft getAircraft(String key) {
        try {
            Aircraft aircraft = jdbcTemplate.queryForObject(
                Constants.GET_AIRCRAFT, new Object[] {Integer.parseInt(key)}, aircraftMapper);
            return aircraft;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Aircraft> aircraftMapper = (rs, rowNum) -> {
        return new Aircraft(rs.getString("aircraft_id"), rs.getDouble("capacity"),
            rs.getString("flight_number"), rs.getDouble("routing_range"), rs.getString("name"));
    };

    public List<Flight> getFlights() {
        try {
            List<Flight> flights = new ArrayList<Flight>();
            flights.addAll(
                jdbcTemplate.query(Constants.GET_FLIGHTS, new Object[] {}, flightMapper));
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Flight> getFlights(String limit) {
        try {
            List<Flight> flights = new ArrayList<Flight>();
            flights.addAll(jdbcTemplate.query(Constants.GET_FLIGHTS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, flightMapper));
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Flight> getFlights(String arriving, String departing) {
        try {
            List<Flight> flights = new ArrayList<Flight>();
            flights.addAll(jdbcTemplate.query(
                Constants.GET_FLIGHTS_W_ARPT, new Object[] {arriving, departing}, flightMapper));
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    public Flight getFlight(String key) {
        try {
            Flight flight = jdbcTemplate.queryForObject(
                Constants.GET_FLIGHT_W_KEY, new Object[] {Integer.parseInt(key)}, flightMapper);
            return flight;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Flight> flightMapper = (rs, rowNum) -> {
        return new Flight(rs.getString("flight_number"), rs.getInt("terminal_number"),
            rs.getString("gate"), rs.getInt("routing"), rs.getString("arrival"),
            rs.getString("departing"), rs.getInt("availability"), rs.getString("status"),
            rs.getDouble("cost"));
    };

    public List<Airport> getAirports() {
        try {
            List<Airport> airports = new ArrayList<Airport>();
            airports.addAll(
                jdbcTemplate.query(Constants.GET_AIRPORTS, new Object[] {}, airportMapper));
            return airports;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Airport> getAirports(String limit) {
        try {
            List<Airport> airports = new ArrayList<Airport>();
            airports.addAll(jdbcTemplate.query(Constants.GET_AIRPORTS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, airportMapper));
            return airports;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Airport> airportMapper = (rs, rowNum) -> {
        return new Airport(rs.getString("airport_id"), rs.getString("a_name"),
            rs.getString("a_city"), rs.getString("a_country"));
    };

    public List<String> getAirportIDs() {
        try {
            List<String> airportIDs =
                jdbcTemplate.queryForList(Constants.GET_AIRPORT_IDS, String.class);
            return airportIDs;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Employee> getEmployees() {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            employees.addAll(
                jdbcTemplate.query(Constants.GET_EMPLOYEES, new Object[] {}, employeeMapper));
            return employees;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Employee> getEmployees(String limit) {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            employees.addAll(jdbcTemplate.query(Constants.GET_EMPLOYEES_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, employeeMapper));
            return employees;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Employee> employeeMapper = (rs, rowNum) -> {
        return new Employee(rs.getString("employee_id"), rs.getString("aircraft_id"),
            rs.getString("airport_id"), rs.getString("job_id"), rs.getString("e_first_name"),
            rs.getString("e_last_name"), rs.getDate("date_hired"));
    };

    public List<Contact> getContacts() {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            contacts.addAll(
                jdbcTemplate.query(Constants.GET_CONTACTS, new Object[] {}, contactMapper));
            return contacts;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Contact> getContacts(String limit) {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            contacts.addAll(jdbcTemplate.query(Constants.GET_CONTACTS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, contactMapper));
            return contacts;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Contact> contactMapper = (rs, rowNum) -> {
        return new Contact(rs.getString("contact_id"), rs.getString("ct_first_name"),
            rs.getString("ct_last_name"), rs.getString("ct_phone_number"), rs.getString("ct_email"),
            rs.getString("ct_relationship"));
    };

    public List<Job> getJobs() {
        try {
            List<Job> jobs = new ArrayList<Job>();
            jobs.addAll(jdbcTemplate.query(Constants.GET_JOBS, new Object[] {}, jobMapper));
            return jobs;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Job> getJobs(String limit) {
        try {
            List<Job> jobs = new ArrayList<Job>();
            jobs.addAll(jdbcTemplate.query(
                Constants.GET_JOBS_W_LIMIT, new Object[] {Integer.parseInt(limit)}, jobMapper));
            return jobs;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Job> jobMapper = (rs, rowNum) -> {
        return new Job(rs.getString("job_id"), rs.getString("job_type"), rs.getDouble("salary"));
    };

    public List<Payment> getPayments() {
        try {
            List<Payment> payments = new ArrayList<Payment>();
            payments.addAll(
                jdbcTemplate.query(Constants.GET_PAYMENTS, new Object[] {}, paymentMapper));
            return payments;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Payment> getPayments(String limit) {
        try {
            List<Payment> payments = new ArrayList<Payment>();
            payments.addAll(jdbcTemplate.query(Constants.GET_PAYMENTS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, paymentMapper));
            return payments;
        } catch (Exception e) {
            throw e;
        }
    }

    public Payment getLatestPayment() {
        try {
            Payment payment = jdbcTemplate.queryForObject(
                Constants.GET_LATEST_PAYMENT, new Object[] {}, paymentMapper);
            return payment;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Payment> paymentMapper = (rs, rowNum) -> {
        return new Payment(rs.getString("invoice_id"), rs.getString("vendor_name"),
            rs.getString("csv"), rs.getString("method"), rs.getString("card_number"),
            rs.getDouble("cost"));
    };

    public List<Reservation> getReservations() {
        try {
            List<Reservation> reservations = new ArrayList<Reservation>();
            reservations.addAll(
                jdbcTemplate.query(Constants.GET_RESERVATIONS, new Object[] {}, reservationMapper));
            return reservations;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Reservation> getReservations(String limit) {
        try {
            List<Reservation> reservations = new ArrayList<Reservation>();
            reservations.addAll(jdbcTemplate.query(Constants.GET_RESERVATIONS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, reservationMapper));
            return reservations;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Reservation> reservationMapper = (rs, rowNum) -> {
        return new Reservation(rs.getString("reservation_id"), rs.getInt("seat_number"),
            rs.getString("accommodations"), rs.getString("aircraft_id"), rs.getString("invoice_id"),
            rs.getBoolean("insurance"));
    };

    public List<Cancellation> getCancellations() {
        try {
            List<Cancellation> cancellations = new ArrayList<Cancellation>();
            cancellations.addAll(jdbcTemplate.query(
                Constants.GET_CANCELLATIONS, new Object[] {}, cancellationMapper));
            return cancellations;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Cancellation> getCancellations(String limit) {
        try {
            List<Cancellation> cancellations = new ArrayList<Cancellation>();
            cancellations.addAll(jdbcTemplate.query(Constants.GET_CANCELLATIONS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, cancellationMapper));
            return cancellations;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Cancellation> cancellationMapper = (rs, rowNum) -> {
        return new Cancellation(rs.getString("reservation_id"), rs.getDate("cancel_date"));
    };

    public List<PlaneService> getPlaneServices() {
        try {
            List<PlaneService> services = new ArrayList<PlaneService>();
            services.addAll(
                jdbcTemplate.query(Constants.GET_SERVICES, new Object[] {}, serviceMapper));
            return services;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<PlaneService> getPlaneServices(String limit) {
        try {
            List<PlaneService> services = new ArrayList<PlaneService>();
            services.addAll(jdbcTemplate.query(Constants.GET_SERVICES_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, serviceMapper));
            return services;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper serviceMapper = (rs, rowNum) -> {
        return new PlaneService(rs.getString("service_id"), rs.getString("movie"),
            rs.getString("wifi"), rs.getString("meal"));
    };

    public List<Customer> getCustomers() {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            customers.addAll(
                jdbcTemplate.query(Constants.GET_CUSTOMERS, new Object[] {}, customerMapper));
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Customer> getCustomers(String limit) {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            customers.addAll(jdbcTemplate.query(Constants.GET_CUSTOMERS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, customerMapper));
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Customer> customerMapper = (rs, rowNum) -> {
        return new Customer(rs.getString("customer_id"), rs.getString("c_first_name"),
            rs.getString("c_last_name"), rs.getString("email"), rs.getBoolean("passport"),
            rs.getString("street"), rs.getString("c_city"), rs.getString("c_state"),
            rs.getString("c_country"), rs.getString("contact_id"), rs.getString("reservation_id"));
    };

    public List<Membership> getMemberships() {
        try {
            List<Membership> memberships = new ArrayList<Membership>();
            memberships.addAll(
                jdbcTemplate.query(Constants.GET_MEMBERSHIPS, new Object[] {}, membershipMapper));
            return memberships;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Membership> getMemberships(String limit) {
        try {
            List<Membership> memberships = new ArrayList<Membership>();
            memberships.addAll(jdbcTemplate.query(Constants.GET_MEMBERSHIPS_W_LIMIT,
                new Object[] {Integer.parseInt(limit)}, membershipMapper));
            return memberships;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Membership> membershipMapper = (rs, rowNum) -> {
        return new Membership(rs.getString("membership_id"), rs.getDouble("discount"),
            rs.getString("customer_id"), rs.getString("m_type"));
    };

    public int insertAirport(
        String airportID, String airportName, String airportCity, String airportCountry) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_AIRPORT,
                new Object[] {airportID, airportName, airportCity, airportCountry});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertFlight(int terminalNumber, String gate, int routing, String arrival,
        String departing, int availability, String status, Double cost) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_FLIGHT,
                new Object[] {
                    terminalNumber, gate, routing, arrival, departing, availability, status, cost});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertAircraft(
        double capacity, String flightNumber, double routing_range, String name) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_AIRCRAFT,
                new Object[] {capacity, flightNumber, routing_range, name});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertEmployee(String aircraftID, String airportID, String jobID, String firstName,
        String lastName, Date dateHired) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_EMPLOYEE,
                new Object[] {aircraftID, airportID, jobID, firstName, lastName, dateHired});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertContact(
        String firstName, String lastName, String phoneNumber, String email, String relationship) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_CONTACT,
                new Object[] {firstName, lastName, phoneNumber, email, relationship});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }
    public int insertJob(String type, Double salary) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_JOB, new Object[] {type, salary});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertPayment(
        String vendorName, String csv, String method, String card_number, Double cost) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_PAYMENT,
                new Object[] {vendorName, csv, method, card_number, cost});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertReservation(int seatNumber, String accommodations, String aircraftID,
        String invoiceID, Boolean insurance) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_RESERVATION,
                new Object[] {seatNumber, accommodations, Integer.parseInt(aircraftID),
                    Integer.parseInt(invoiceID), insurance});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertCancellation(String reservationID, Date cancelDate) {
        try {
            int i = jdbcTemplate.update(
                Constants.INSERT_CANCELLATION, new Object[] {reservationID, cancelDate});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertPlaneService(String movie, String wifi, String meal) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_SERVICE, new Object[] {movie, wifi, meal});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertCustomer(String firstName, String lastName, String email, Boolean passport,
        String street, String city, String state, String country, String contactID,
        String reservationID) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_CUSTOMER,
                new Object[] {
                    firstName, lastName, email, passport, street, city, state, country, contactID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int insertMembership(Double discount, String customerID, String type) {
        try {
            int i = jdbcTemplate.update(
                Constants.INSERT_MEMBERSHIP, new Object[] {discount, customerID, type});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateAirport(
        String airportID, String airportName, String airportCity, String airportCountry) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_AIRPORT,
                new Object[] {airportID, airportName, airportCity, airportCountry, airportID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateFlight(String flightNumber, int terminalNumber, String gate, int routing,
        String arrival, String departing, int availability, String status, Double cost) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_FLIGHT,
                new Object[] {flightNumber, terminalNumber, gate, routing, arrival, departing,
                    availability, status, cost, flightNumber});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateAircraft(String aircraftID, double capacity, String flightNumber,
        double routing_range, String name) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_AIRCRAFT,
                new Object[] {aircraftID, capacity, flightNumber, routing_range, name, aircraftID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateEmployee(String employeeID, String aircraftID, String airportID, String jobID,
        String firstName, String lastName, Date dateHired) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_EMPLOYEE,
                new Object[] {employeeID, aircraftID, airportID, jobID, firstName, lastName,
                    dateHired, employeeID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateContact(String contactID, String firstName, String lastName,
        String phoneNumber, String email, String relationship) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_CONTACT,
                new Object[] {
                    contactID, firstName, lastName, phoneNumber, email, relationship, contactID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateJob(String jobID, String type, Double salary) {
        try {
            int i = jdbcTemplate.update(
                Constants.UPDATE_JOB, new Object[] {jobID, type, salary, jobID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    // TODO: ADD PRIMARY KEY
    public int updatePayment(String paymentID, String vendorName, int vendorID, String method) {
        try {
            int i = jdbcTemplate.update(Constants.INSERT_PAYMENT,
                new Object[] {paymentID, vendorName, vendorID, method, paymentID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    // TODO: ADD PRIMARY KEY
    public int updateReservation(String reservationID, int seatNumber, String accommodations,
        String aircraftID, String invoiceID, Boolean insurance) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_RESERVATION,
                new Object[] {reservationID, seatNumber, accommodations,
                    Integer.parseInt(aircraftID), Integer.parseInt(invoiceID), insurance,
                    reservationID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateCancellation(String reservationID, Date cancelDate) {
        try {
            int i = jdbcTemplate.update(
                Constants.UPDATE_CANCELLATION, new Object[] {reservationID, cancelDate});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    // TODO: ADD PRIMARY KEY
    public int updatePlaneService(String serviceID, String movie, String wifi, String meal) {
        try {
            int i = jdbcTemplate.update(
                Constants.UPDATE_SERVICE, new Object[] {serviceID, movie, wifi, meal, serviceID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    // TODO: ADD PRIMARY KEY
    public int updateCustomer(String customerID, String firstName, String lastName, String email,
        Boolean passport, String street, String city, String state, String country,
        String contactID, String reservationID) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_CUSTOMER,
                new Object[] {customerID, firstName, lastName, email, passport, street, city, state,
                    country, contactID, customerID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    // TODO: ADD PRIMARY KEY
    public int updateMembership(
        String membershipID, Double discount, String customerID, String type) {
        try {
            int i = jdbcTemplate.update(Constants.UPDATE_MEMBERSHIP,
                new Object[] {membershipID, discount, customerID, type, membershipID});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteAirport(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_AIRPORT, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteFlight(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_FLIGHT, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteAircraft(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_AIRCRAFT, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteEmployee(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_EMPLOYEE, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteContact(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_CONTACT, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteJob(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_JOB, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deletePayment(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_PAYMENT, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteReservation(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_RESERVATION, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteCancellation(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_CANCELLATION, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deletePlaneService(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_SERVICE, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteCustomer(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_CUSTOMER, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public int deleteMembership(String key) {
        try {
            int i = jdbcTemplate.update(Constants.DELETE_MEMBERSHIP, new Object[] {key});
            return i;
        } catch (Exception e) {
            throw e;
        }
    }
}
