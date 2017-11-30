package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private Double phoneNumber; // TODO: This should be a String
    private String email;
    private String relationship;

    public Contact() {}

    public Contact(String id, String firstName, String lastName, Double phoneNumber, String email,
        String relationship) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.relationship = relationship;
    }
}
