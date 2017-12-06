package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String relationship;

    public Contact() {}

    public Contact(String id, String firstName, String lastName, String phoneNumber, String email,
        String relationship) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.relationship = relationship;
    }
}
