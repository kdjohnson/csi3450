package edu.oakland.csi3450.service;

public class Constants {
    public static final String GET_COL_NAMES =
        new String("SELECT column_name FROM information_schema.columns WHERE table_name = ?")
            .replaceAll("\\s+", " ");

    public static final String GET_DATA_TYPES =
        new String("SELECT data_type FROM information_schema.columns WHERE table_name = ?")
            .replaceAll("\\s+", " ");

    public static final String GET_FLIGHTS =
        new String("SELECT * FROM flight").replaceAll("\\s+", " ");

    public static final String GET_FLIGHTS_W_LIMIT =
        new String("SELECT * FROM flight LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_FLIGHTS_W_ARPT =
        new String("SELECT * FROM flight WHERE arrival = ? AND departing = ?")
            .replaceAll("\\s+", " ");

    public static final String GET_FLIGHT_W_KEY =
        new String("SELECT * FROM flight WHERE flight_number = ?");

    public static final String GET_AIRCRAFT =
        new String("SELECT * FROM aircraft WHERE flight_number = ?").replaceAll("\\s+", " ");

    public static final String GET_AIRCRAFTS =
        new String("SELECT * FROM aircraft").replaceAll("\\s+", " ");

    public static final String GET_AIRCRAFTS_W_LIMIT =
        new String("SELECT * FROM aircraft LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_AIRPORTS =
        new String("SELECT * FROM airport").replaceAll("\\s+", " ");

    public static final String GET_AIRPORTS_W_LIMIT =
        new String("SELECT * FROM airport LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_AIRPORT_IDS =
        new String("SELECT airport_id FROM airport").replaceAll("\\s+", " ");

    public static final String GET_EMPLOYEES =
        new String("SELECT * FROM employee").replaceAll("\\s+", " ");

    public static final String GET_EMPLOYEES_W_LIMIT =
        new String("SELECT * FROM employee LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_CUSTOMERS =
        new String("SELECT * FROM customer").replaceAll("\\s+", " ");

    public static final String GET_CUSTOMERS_W_LIMIT =
        new String("SELECT * FROM customer LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_MEMBERSHIPS =
        new String("SELECT * FROM membership").replaceAll("\\s+", " ");

    public static final String GET_MEMBERSHIPS_W_LIMIT =
        new String("SELECT * FROM membership LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_SERVICES =
        new String("SELECT * FROM services").replaceAll("\\s+", " ");

    public static final String GET_SERVICES_W_LIMIT =
        new String("SELECT * FROM services LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_PAYMENTS =
        new String("SELECT * FROM payment").replaceAll("\\s+", " ");

    public static final String GET_PAYMENTS_W_LIMIT =
        new String("SELECT * FROM payment LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_LATEST_PAYMENT =
        new String("SELECT * FROM payment order by invoice_id desc limit 1")
            .replaceAll("\\s+", " ");

    public static final String GET_JOBS = new String("SELECT * FROM jobs").replaceAll("\\s+", " ");

    public static final String GET_JOBS_W_LIMIT =
        new String("SELECT * FROM jobs LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_CONTACTS =
        new String("SELECT * FROM contact").replaceAll("\\s+", " ");

    public static final String GET_CONTACTS_W_LIMIT =
        new String("SELECT * FROM contact LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_RESERVATIONS =
        new String("SELECT * FROM reservation").replaceAll("\\s+", " ");

    public static final String GET_RESERVATIONS_W_LIMIT =
        new String("SELECT * FROM reservation LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_CANCELLATIONS =
        new String("SELECT * FROM cancellation").replaceAll("\\s+", " ");

    public static final String GET_CANCELLATIONS_W_LIMIT =
        new String("SELECT * FROM cancellation LIMIT ?").replaceAll("\\s+", " ");

    public static final String GET_TABLE_NAMES = new String(
        "SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'")
                                                     .replaceAll("\\s", " ");

    public static final String INSERT_FLIGHT =
        new String("INSERT into flight VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_FLIGHT = new String(
        "UPDATE flight SET flight_number serial = ?, terminal_number = ?, gate = ?, routing = ?, arrival = ?, departing = ?, availability = ?, status = ?, cost = ? WHERE flight_number = ?");

    public static final String INSERT_AIRCRAFT =
        new String("INSERT into aircraft VALUES (?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_AIRCRAFT = new String(
        "UPDATE aircraft SET aircraft_id = ?, capacity = ?, flight_number = ?, routing_range = ?, name = ? WHERE aircraft_id = ?")
                                                     .replaceAll("\\s+", " ");

    public static final String INSERT_AIRPORT =
        new String("INSERT into airport VALUES (?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_AIRPORT = new String(
        "UPDATE airport SET airport_id = ?, a_name = ?, a_city = ?, a_country = ? WHERE airport_id = ?")
                                                    .replaceAll("\\s+", " ");

    public static final String INSERT_SERVICE =
        new String("INSERT into services VALUES (?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_SERVICE = new String(
        "UPDATE services SET service_id = ?, movie = ?, wifi = ?, meal = ? WHERE service_id = ?")
                                                    .replaceAll("\\s+", " ");

    public static final String INSERT_EMPLOYEE =
        new String("INSERT into employee VALUES (?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_EMPLOYEE = new String(
        "UPDATE employee SET employee_id = ?, aircraft_id = ?, airport_id = ?, job_id = ?, e_first_name = ?, e_last_name = ?, date_hired ? WHERE employee_id = ?")
                                                     .replaceAll("\\s+", " ");

    public static final String INSERT_MEMBERSHIP =
        new String("INSERT into membership VALUES (?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_MEMBERSHIP = new String(
        "UPDATE membership SET membership_id = ?, discount = ?,  customer_id = ?, m_type = ?")
                                                       .replaceAll("\\s+", " ");

    public static final String INSERT_CUSTOMER =
        new String("INSERT into customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
            .replaceAll("\\s+", " ");

    public static final String UPDATE_CUSTOMER = new String(
        "UPDATE customer SET customer_id = ?, c_first_name = ?, c_last_name = ?, email = ?, passport = ?, street = ?, c_city = ?, c_state = ?, c_country = ?, contact_id = ?, reservation_id = ? WHERE customer_id = ?")
                                                     .replaceAll("\\s+", " ");

    public static final String INSERT_CONTACT =
        new String("INSERT into contact VALUES (?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_CONTACT = new String(
        "UPDATE contact SET contact_id = ?, ct_first_name = ?, ct_last_name = ?, ct_phone_number = ?, ct_email = ?, ct_relationship = ? WHERE contact_id = ?")
                                                    .replaceAll("\\s+", " ");

    public static final String INSERT_JOB =
        new String("INSERT into job VALUES (?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_JOB =
        new String("UPDATE job SET job_id = ?, job_type = ?, salary = ? WHERE = salary = ?")
            .replaceAll("\\s+", " ");

    public static final String INSERT_RESERVATION = new String(
        "INSERT into reservation (seat_number, accommodations, aircraft_id, invoice_id, insurance) VALUES (?, ?, ?, ?, ?)")
                                                        .replaceAll("\\s+", " ");

    public static final String UPDATE_RESERVATION = new String(
        "UPDATE reservation SET reservation_id = ?, seat_number = ?, accommodations = ?, aircraft_id = ?, invoice_id = ?, insurance = ?")
                                                        .replaceAll("\\s+", " ");

    public static final String INSERT_PAYMENT_KEY =
        new String("INSERT into payment VALUES (?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_PAYMENT = new String(
        "INSERT into payment(vendor_name, csv, method, card_number, cost) VALUES (?, ?, ?, ?, ?)")
                                                    .replaceAll("\\s+", " ");

    public static final String INSERT_CANCELLATION =
        new String("INSERT into cancellation VALUES (?, ?)").replaceAll("\\s+", " ");

    public static final String UPDATE_CANCELLATION =
        new String("UPDATE cancellation SET reservation_id = ?, cancel_date = ?")
            .replaceAll("\\s+", " ");

    public static final String DELETE_AIRCRAFT =
        new String("DELETE FROM aircraft WHERE aircraft_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_FLIGHT =
        new String("DELETE FROM flight WHERE flight_number = ?").replaceAll("\\s+", " ");

    public static final String DELETE_AIRPORT =
        new String("DELETE FROM airport WHERE airport_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_SERVICE =
        new String("DELETE FROM services WHERE service_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_EMPLOYEE =
        new String("DELETE FROM employee WHERE employee_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_MEMBERSHIP =
        new String("DELETE FROM membership WHERE membership_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_CUSTOMER =
        new String("DELETE FROM customer WHERE customer_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_CONTACT =
        new String("DELETE FROM contact WHERE contact_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_JOB =
        new String("DELETE FROM job WHERE = job_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_RESERVATION =
        new String("DELETE FROM reservation WHERE reservation_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_PAYMENT =
        new String("DELETE FROM payment WHERE payment_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_CANCELLATION =
        new String("DELETE FROM cancellation FROM WHERE reservation_id = ? AND cancel_date = ?")
            .replaceAll("\\s+", " ");
}
