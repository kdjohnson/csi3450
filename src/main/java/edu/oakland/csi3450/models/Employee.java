package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Employee {
    private String id;
    private String flightNumber;
    private String airportID;
    private String jobID;
    private String firstName;
    private String lastName;
    private String dateHired;

    public Employee() {}

    public Employee(String id, String flightNumber, String airportID, String jobID,
        String firstName, String lastName, String dateHired) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airportID = airportID;
        this.jobID = jobID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
    }
}
