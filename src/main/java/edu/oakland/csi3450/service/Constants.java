package edu.oakland.csi3450.service;

public class Constants {
    public static final String GET_FLIGHTS =
        new String("SELECT * FROM flight").replaceAll("\\s+", " ");

    public static final String GET_AIRCRAFTS =
        new String("SELECT * FROM aircraft").replaceAll("\\s+", " ");

    public static final String INSERT_FLIGHT =
        new String("INSERT into flight VALUES (?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_AIRCRAFT =
        new String("INSERT into aircraft VALUES (?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_AIRPORT =
        new String("INSERT into airport VALUES (?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_SERVICE =
        new String("INSERT into services VALUES (?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_EMPLOYEE =
        new String("INSERT into employee VALUES (?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_MEMBERSHIP =
        new String("INSERT into membership VALUES (?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_CUSTOMER =
        new String("INSERT into customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
            .replaceAll("\\s+", " ");

    public static final String INSERT_CONTACT =
        new String("INSERT into contact VALUES (?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_JOB =
        new String("INSERT into job VALUES (?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_RESERVATION =
        new String("INSERT into reservation VALUES (?, ?, ?, ?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_PAYMENT =
        new String("INSERT into payment VALUES (?, ?, ?)").replaceAll("\\s+", " ");

    public static final String INSERT_CANCELLATION =
        new String("INSERT into cancellation VALUES (?, ?)").replaceAll("\\s+", " ");

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
        new String("DELETE FROM job WHERE = job_id").replaceAll("\\s+", " ");

    public static final String DELETE_RESERVATION =
        new String("DELETE FROM reservation WHERE reservation_id = ?").replaceAll("\\s+", " ");

    public static final String DELETE_PAYMENT =
        new String("DELETE FROM payment WHERE payment_id").replaceAll("\\s+", " ");

    public static final String DELETE_CANCELLATION =
        new String("DELETE FROM cancellation FROM WHERE reservation_id = ? AND cancel_date = ?")
            .replaceAll("\\s+", " ");
}
