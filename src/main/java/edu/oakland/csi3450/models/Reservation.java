package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Reservation {
    private String id;
    private int seatNumber;
    private String accommodations;
    private String aircraftID;
    private String invoiceID;
    private Boolean insurance;

    public Reservation() {}

    public Reservation(String id, int seatNumber, String accommodations, String aircraftID,
        String invoiceID, Boolean insurance) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.accommodations = accommodations;
        this.aircraftID = aircraftID;
        this.invoiceID = invoiceID;
        this.insurance = insurance;
    }
}
