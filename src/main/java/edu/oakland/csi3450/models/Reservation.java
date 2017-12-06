package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Reservation {
    private String id;
    private int seatNumber;
    private String accommodations;
    private String flightNumber;
    private String invoiceID;
    private Boolean insurance;

    public Reservation() {}

    public Reservation(String id, int seatNumber, String accommodations, String flightNumber,
        String invoiceID, Boolean insurance) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.accommodations = accommodations;
        this.flightNumber = flightNumber;
        this.invoiceID = invoiceID;
        this.insurance = insurance;
    }
}
