package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean passport;
    private String street;
    private String city;
    private String state;
    private String country;
    private String contactID;
    private String reservationID;

    public Customer() {}

    public Customer(String id, String firstName, String lastName, String email, Boolean passport,
        String street, String city, String state, String country, String contactID,
        String reservationID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passport = passport;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.contactID = contactID;
        this.reservationID = reservationID;
    }
}
