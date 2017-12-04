package edu.oakland.csi3450.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.oakland.csi3450.models.*;
import edu.oakland.csi3450.service.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/")
public class Api {
    @Autowired IDB db;

    @RequestMapping(value = "describeTable", produces = "application/json")
    public Map<String, List<String>> getColNames(@RequestParam("table") String table) {
        try {
            List<String> names = db.getColNames(table);
            List<String> types = db.getDataTypes(table);
            Map map = new HashMap();
            map.put("names", names);
            map.put("types", types);
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"flights", "flight"}, produces = "application/json")
    public List<Flight> flights(@RequestParam("limit") String limit) {
        try {
            List<Flight> flights = new ArrayList<Flight>();
            if (Objects.equals(limit, null)) {
                flights = db.getFlights();
            } else {
                flights = db.getFlights(limit);
            }
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"aircrafts", "aircraft"}, produces = "application/json")
    public List<Aircraft> aircrafts(@RequestParam("limit") String limit) {
        try {
            List<Aircraft> aircrafts = new ArrayList<Aircraft>();
            if (Objects.equals(limit, null)) {
                aircrafts = db.getAircrafts();
            } else {
                aircrafts = db.getAircrafts(limit);
            }
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"airports", "airport"}, produces = "application/json")
    public List<Airport> airports(@RequestParam("limit") String limit) {
        try {
            List<Airport> airports = new ArrayList<Airport>();
            if (Objects.equals(limit, null)) {
                airports = db.getAirports();
            } else {
                airports = db.getAirports(limit);
            }
            return airports;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = "airportIDs", produces = "application/json")
    public List<String> airportIDs() {
        try {
            List<String> airportIDs = db.getAirportIDs();
            return airportIDs;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"reservation"}, produces = "application/json")
    public List<Reservation> reservations(@RequestParam("limit") String limit) {
        try {
            List<Reservation> reservations = new ArrayList<Reservation>();
            if (Objects.equals(limit, null)) {
                reservations = db.getReservations();
            } else {
                reservations = db.getReservations(limit);
            }
            return reservations;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"contact"}, produces = "application/json")
    public List<Contact> contacts(@RequestParam("limit") String limit) {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            if (Objects.equals(limit, null)) {
                contacts = db.getContacts();
            } else {
                contacts = db.getContacts(limit);
            }
            return contacts;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"cancellations"}, produces = "application/json")
    public List<Cancellation> cancellations(@RequestParam("limit") String limit) {
        try {
            List<Cancellation> cancellations = new ArrayList<Cancellation>();
            if (Objects.equals(limit, null)) {
                cancellations = db.getCancellations();
            } else {
                cancellations = db.getCancellations(limit);
            }
            return cancellations;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"job"}, produces = "application/json")
    public List<Job> jobs(@RequestParam("limit") String limit) {
        try {
            List<Job> jobs = new ArrayList<Job>();
            if (Objects.equals(limit, null)) {
                jobs = db.getJobs();
            } else {
                jobs = db.getJobs(limit);
            }
            return jobs;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"payment"}, produces = "application/json")
    public List<Payment> payments(@RequestParam("limit") String limit) {
        try {
            List<Payment> payments = new ArrayList<Payment>();
            if (Objects.equals(limit, null)) {
                payments = db.getPayments();
            } else {
                payments = db.getPayments(limit);
            }
            return payments;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"services"}, produces = "application/json")
    public List<PlaneService> planceServices(@RequestParam("limit") String limit) {
        try {
            List<PlaneService> planeServices = new ArrayList<PlaneService>();
            if (Objects.equals(limit, null)) {
                planeServices = db.getPlaneServices();
            } else {
                planeServices = db.getPlaneServices(limit);
            }
            return planeServices;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"employee"}, produces = "application/json")
    public List<Employee> employees(@RequestParam("limit") String limit) {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            if (Objects.equals(limit, null)) {
                db.getEmployees();
            } else {
                db.getEmployees(limit);
            }
            return employees;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"customer"}, produces = "application/json")
    public List<Customer> customers(@RequestParam("limit") String limit) {
        try {
            List<Customer> customers = new ArrayList<Customer>();
            if (Objects.equals(limit, null)) {
                customers = db.getCustomers();
            } else {
                customers = db.getCustomers(limit);
            }
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"membership"}, produces = "application/json")
    public List<Membership> memberships(@RequestParam("limit") String limit) {
        try {
            List<Membership> memberships = new ArrayList<Membership>();
            if (Objects.equals(limit, null)) {
                memberships = db.getMemberships();
            } else {
                memberships = db.getMemberships(limit);
            }
            return memberships;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/airport"}, produces = "application/json")
    public int insertAirport(@RequestParam("airport_id") String airport_id,
        @RequestParam("a_name") String a_name, @RequestParam("a_city") String a_city,
        @RequestParam("a_country") String a_country) {
        try {
            int i = db.insertAirport(airport_id, a_name, a_city, a_country);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/flight"}, produces = "application/json")
    int insertFlight(@RequestParam("flight_number") String flightNumber,
        @RequestParam("terminal_number") String terminalNumber, @RequestParam("gate") String gate,
        @RequestParam("routing") String routing, @RequestParam("arrival") String arrival,
        @RequestParam("departing") String departing,
        @RequestParam("availability") String availability, @RequestParam("s") String status) {
        try {
            int i = db.insertFlight(flightNumber, Integer.parseInt(terminalNumber), gate,
                Integer.parseInt(routing), arrival, departing, Integer.parseInt(availability),
                status);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/aircraft"}, produces = "application/json")
    int insertAircraft(@RequestParam("capacity") String capacity,
        @RequestParam("flight_number") String flightNumber,
        @RequestParam("routing_range") String routing_range, @RequestParam("name") String name) {
        try {
            int i = db.insertAircraft(Double.parseDouble(capacity), flightNumber,
                Double.parseDouble(routing_range), name);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/employee"}, produces = "application/json")
    int insertEmployee(@RequestParam("airport_id") String aircraftID,
        @RequestParam("aircraft_id") String airportID, @RequestParam("job_id") String jobID,
        @RequestParam("e_first_name") String firstName,
        @RequestParam("e_last_name") String lastName, @RequestParam("date_hired") Date dateHired) {
        try {
            int i = db.insertEmployee(aircraftID, airportID, jobID, firstName, lastName, dateHired);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/contact"}, produces = "application/json")
    int insertContact(@RequestParam("ct_first_name") String firstName,
        @RequestParam("ct_last_name") String lastName,
        @RequestParam("ct_phone_number") String phoneNumber, @RequestParam("ct_email") String email,
        @RequestParam("ct_relationship") String relationship) {
        try {
            int i = db.insertContact(
                firstName, lastName, Double.parseDouble(phoneNumber), email, relationship);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/job"}, produces = "application/json")
    int insertJob(@RequestParam("job_type") String type, @RequestParam("salary") String salary) {
        try {
            int i = db.insertJob(type, Double.parseDouble(salary));
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/payment"}, produces = "application/json")
    int insertPayment(@RequestParam("vendor_name") String vendorName,
        @RequestParam("vendor_id") String vendorID, @RequestParam("method") String method) {
        try {
            int i = db.insertPayment(vendorName, Integer.parseInt(vendorID), method);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/reservation"}, produces = "application/json")
    int insertReservation(@RequestParam("luggage_weight") String luggageWeight,
        @RequestParam("seat_number") String seatNumber,
        @RequestParam("accommodations") String accommodations,
        @RequestParam("aircraft_id") String aircraftID,
        @RequestParam("invoice_id") String invoiceID, @RequestParam("insurance") String insurance) {
        try {
            int i =
                db.insertReservation(Integer.parseInt(luggageWeight), Integer.parseInt(seatNumber),
                    accommodations, aircraftID, invoiceID, Boolean.parseBoolean(insurance));
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/cancellations"}, produces = "application/json")
    int insertCancellation(@RequestParam("reservation_id") String reservationID,
        @RequestParam("cancel_date") Date cancelDate) {
        try {
            int i = db.insertCancellation(reservationID, cancelDate);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/services"}, produces = "application/json")
    int insertPlaneService(@RequestParam("movie") String movie, @RequestParam("wifi") String wifi,
        @RequestParam("meal") String meal) {
        try {
            int i = db.insertPlaneService(movie, wifi, meal);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/customer"}, produces = "application/json")
    int insertCustomer(@RequestParam("c_first_name") String firstName,
        @RequestParam("c_last_name") String lastName, @RequestParam("email") String email,
        @RequestParam("passport") String passport, @RequestParam("street") String street,
        @RequestParam("c_city") String city, @RequestParam("c_state") String state,
        @RequestParam("c_country") String country, @RequestParam("contact_id") String contactID,
        @RequestParam("reservation_id") String reservationID) {
        try {
            int i = db.insertCustomer(firstName, lastName, email, Boolean.parseBoolean(passport),
                street, city, state, country, contactID, reservationID);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"insert/membership"}, produces = "application/json")
    int insertMembership(@RequestParam("discount") String discount,
        @RequestParam("customer_id") String customerID, @RequestParam("m_type") String type) {
        try {
            int i = db.insertMembership(Double.parseDouble(discount), customerID, type);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = "update/airport", produces = "application/json")
    public int updateAirport(@RequestParam("airport_id") String airport_id,
        @RequestParam("a_name") String a_name, @RequestParam("a_city") String a_city,
        @RequestParam("a_country") String a_country) {
        try {
            int i = db.updateAirport(airport_id, a_name, a_city, a_country);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/flight"}, produces = "application/json")
    int updateFlight(@RequestParam("flight_number") String flightNumber,
        @RequestParam("terminal_number") String terminalNumber, @RequestParam("gate") String gate,
        @RequestParam("routing") String routing, @RequestParam("arrival") String arrival,
        @RequestParam("departing") String departing,
        @RequestParam("availability") String availability, @RequestParam("s") String status) {
        try {
            int i = db.updateFlight(flightNumber, Integer.parseInt(terminalNumber), gate,
                Integer.parseInt(routing), arrival, departing, Integer.parseInt(availability),
                status);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/aircraft"}, produces = "application/json")
    int updateAircraft(@RequestParam("aircraft_id") String aircraftID,
        @RequestParam("capacity") String capacity,
        @RequestParam("flight_number") String flightNumber,
        @RequestParam("routing_range") String routingRange, @RequestParam("name") String name) {
        try {
            int i = db.updateAircraft(aircraftID, Double.parseDouble(capacity), flightNumber,
                Double.parseDouble(routingRange), name);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/employee"}, produces = "application/json")
    int updateEmployee(@RequestParam("employee_id") String employeeID,
        @RequestParam("airport_id") String aircraftID,
        @RequestParam("aircraft_id") String airportID, @RequestParam("job_id") String jobID,
        @RequestParam("e_first_name") String firstName,
        @RequestParam("e_last_name") String lastName, @RequestParam("date_hired") Date dateHired) {
        try {
            int i = db.updateEmployee(
                employeeID, aircraftID, airportID, jobID, firstName, lastName, dateHired);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/contact"}, produces = "application/json")
    int updateContact(@RequestParam("contact_id") String contactID,
        @RequestParam("ct_first_name") String firstName,
        @RequestParam("ct_last_name") String lastName,
        @RequestParam("ct_phone_number") String phoneNumber, @RequestParam("ct_email") String email,
        @RequestParam("ct_relationship") String relationship) {
        try {
            int i = db.updateContact(contactID, firstName, lastName,
                Double.parseDouble(phoneNumber), email, relationship);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/job"}, produces = "application/json")
    int updateJob(@RequestParam("job_id") String jobID, @RequestParam("job_type") String type,
        @RequestParam("salary") String salary) {
        try {
            int i = db.updateJob(jobID, type, Double.parseDouble(salary));
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/payment"}, produces = "application/json")
    int updatePayment(@RequestParam("invoice_id") String invoiceID,
        @RequestParam("vendor_name") String vendorName, @RequestParam("vendor_id") String vendorID,
        @RequestParam("method") String method) {
        try {
            int i = db.updatePayment(invoiceID, vendorName, Integer.parseInt(vendorID), method);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/reservation"}, produces = "application/json")
    int updateReservation(@RequestParam("reservation_id") String reservationID,
        @RequestParam("luggage_weight") String luggageWeight,
        @RequestParam("seat_number") String seatNumber,
        @RequestParam("accommodations") String accommodations,
        @RequestParam("aircraft_id") String aircraftID,
        @RequestParam("invoice_id") String invoiceID, @RequestParam("insurance") String insurance) {
        try {
            int i = db.updateReservation(reservationID, Integer.parseInt(luggageWeight),
                Integer.parseInt(seatNumber), accommodations, aircraftID, invoiceID,
                Boolean.parseBoolean(insurance));
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/cancellations"}, produces = "application/json")
    int updateCancellation(@RequestParam("reservation_id") String reservationID,
        @RequestParam("cancel_date") Date cancelDate) {
        try {
            int i = db.updateCancellation(reservationID, cancelDate);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/services"}, produces = "application/json")
    int updatePlaneService(@RequestParam("service_id") String serviceID,
        @RequestParam("movie") String movie, @RequestParam("wifi") String wifi,
        @RequestParam("meal") String meal) {
        try {
            int i = db.updatePlaneService(serviceID, movie, wifi, meal);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/customer"}, produces = "application/json")
    int updateCustomer(@RequestParam("customer_id") String customerID,
        @RequestParam("c_first_name") String firstName,
        @RequestParam("c_last_name") String lastName, @RequestParam("email") String email,
        @RequestParam("passport") String passport, @RequestParam("street") String street,
        @RequestParam("c_city") String city, @RequestParam("c_state") String state,
        @RequestParam("c_country") String country, @RequestParam("contact_id") String contactID,
        @RequestParam("reservation_id") String reservationID) {
        try {
            int i = db.updateCustomer(customerID, firstName, lastName, email,
                Boolean.parseBoolean(passport), street, city, state, country, contactID,
                reservationID);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"update/membership"}, produces = "application/json")
    int updateMembership(@RequestParam("membership_id") String membershipID,
        @RequestParam("discount") String discount, @RequestParam("customer_id") String customerID,
        @RequestParam("m_type") String type) {
        try {
            int i =
                db.updateMembership(membershipID, Double.parseDouble(discount), customerID, type);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/airport"}, produces = "application/json")
    int deleteAirport(@RequestParam("key") String key) {
        try {
            int i = db.deleteAirport(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/flight"}, produces = "application/json")
    int deleteFlight(@RequestParam("key") String key) {
        try {
            int i = db.deleteFlight(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/aircraft"}, produces = "application/json")
    int deleteAircraft(@RequestParam("key") String key) {
        try {
            int i = db.deleteAircraft(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/employee"}, produces = "application/json")
    int deleteEmployee(@RequestParam("key") String key) {
        try {
            int i = db.deleteEmployee(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/contact"}, produces = "application/json")
    int deleteContact(@RequestParam("key") String key) {
        try {
            int i = db.deleteContact(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/job"}, produces = "application/json")
    int deleteJob(@RequestParam("key") String key) {
        try {
            int i = db.deleteJob(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/payment"}, produces = "application/json")
    int deletePayment(@RequestParam("key") String key) {
        try {
            int i = db.deletePayment(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/reservation"}, produces = "application/json")
    int deleteReservation(@RequestParam("key") String key) {
        try {
            int i = db.deleteReservation(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/cancellation"}, produces = "application/json")
    int deleteCancellation(@RequestParam("key") String key) {
        try {
            int i = db.deleteCancellation(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/services"}, produces = "application/json")
    int deleteServices(@RequestParam("key") String key) {
        try {
            int i = db.deleteEmployee(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/customer"}, produces = "application/json")
    int deleteCustomer(@RequestParam("key") String key) {
        try {
            int i = db.deleteCustomer(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = {"delete/membership"}, produces = "application/json")
    int deleteMembership(@RequestParam("key") String key) {
        try {
            int i = db.deleteMembership(key);
            return i;
        } catch (Exception e) {
            throw e;
        }
    }
}
