package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Employee {
    private String id;
    private String aircraftID;
    private String airportID;
    private String jobID;
    private String firstName;
    private String lastName;
    private Date dateHired;

    public Employee() {}

    public Employee(String id, String aircraftID, String airportID, String jobID, String firstName,
        String lastName, Date dateHired) {
        this.id = id;
        this.aircraftID = aircraftID;
        this.airportID = airportID;
        this.jobID = jobID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
    }
}
