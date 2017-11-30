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
import java.util.ArrayList;

@Service
public class DB implements IDB {
    @Autowired private JdbcTemplate jdbcTemplate;

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

    RowMapper<Flight> flightMapper = (rs, rowNum) -> {
        return new Flight(rs.getString("flight_number"), rs.getInt("terminal_number"),
            rs.getString("gate"), rs.getInt("routing"), rs.getString("arrival"),
            rs.getString("departing"), rs.getInt("availability"), rs.getString("s"));
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
            employees.addAll(jdbcTemplate.query(Constants.GET_EMPLOYEES, new Object[] {}, employeeMapper);
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
            contacts.addAll(jdbcTemplate.query(Constants.GET_CONTACTS, new Object[] {}, contactMapper);
            return contacts;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Contact> contactMapper = (rs, rowNum) -> {
        return new Contact(rs.getString("contact_id"), rs.getString("ct_first_name "),
            rs.getString("ct_last_name"), rs.getDouble("ct_phone_number"), rs.getString("ct_email"),
            rs.getString("ct_relationship"));
    };

    public List<Job> getJobs() {
        try {
            List<Job> jobs = new ArrayList<Job>();
            jobs.addAll(jdbcTemplate.query(Constants.GET_JOBS, new Object[] {}, jobMapper);
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
            payments.addAll(jdbcTemplate.query(Constants.GET_PAYMENTS, new Object[] {}, paymentMapper);
            return payments;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Payment> paymentMapper = (rs, rowNum) -> {
        return new Payment(rs.getString("invoice_id"), rs.getString("vendor_name"),
            rs.getString("vendor_id"), rs.getString("method"));
    };

    public List<Reservation> getReservations() {
        try {
            List<Reservation> reservations = new ArrayList<Reservation>();
            reservations.addAll(jdbcTemplate.query(Constants.GET_RESERVATIONS, new Object[] {}, reservationMapper);
            return reservations;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Reservation> reservationMapper = (rs, rowNum) -> {
        return new Reservation(rs.getString("reservation_id"), rs.getInt("luggage_weight"),
            rs.getInt("seat_number"), rs.getString("accommodations"), rs.getString("aircraft_id"),
            rs.getString("invoice_id"), rs.getBoolean("insurance"));
    };

    public List<Cancellation> getCancellations() {
        try {
            List<Cancellation> cancellations = new ArrayList<Cancellation>();
            cancellations.addAll(jdbcTemplate.query(Constants.GET_CANCELLATIONS, new Object[] {}, cancellationMapper);
            return reservations;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Cancellation> cancellationMapper = (rs, rowNum) -> {
        return new Cancellation(rs.getString("reservation_id"), rs.getDate("cancel_date"));
    };

    public List<Service> getServices() {
        try {
            List<Service> services = new ArrayList<Service>();
            services.addAll(jdbcTemplate.query(Constants.GET_SERVICES, new Object[] {}, serviceMapper);
            return services;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper serviceMapper = (rs, rowNum) -> {
        return new Service(rs.getString("service_id"), rs.getString("movie"), rs.getString("wifi"),
            rs.getString("meal"));
    };

    public List<Customer> getCustomer() {
        try {
            List<Customer> reservations = new ArrayList<Customer>();
            customer.addAll(jdbcTemplate.query(Constants.GET_CUSTOMERS, new Object[] {}, customerMapper);
            return customer;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Customer> customerMapper = (rs, rowNum) -> {
        return new Customer(rs.getString("customer_id"), rs.getString("c_first_name"),
            rs.getString("c_last_name"), rs.getString("email"), rs.getString(""));
    };

    public List<Membership> getMemberships() {
        try {
            List<Membership> reservations = new ArrayList<Membership>();
            membership.addAll(jdbcTemplate.query(Constants.GET_MEMBERSHIPS, new Object[] {}, membershipMapper);
            return memberships;
        } catch (Exception e) {
            throw e;
        }
    }
}
