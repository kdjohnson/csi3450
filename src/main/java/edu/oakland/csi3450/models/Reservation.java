package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Reservation {
    private String id;
    private int luggageWeight;
    private int seatNumber;
    private String accommodations;
    private String aircraftID;
    private String invoiceID;
    private Boolean insurance;

    public Reservation() {}

    public Reservation(String id, int luggageWeight, int seatNumber, String accommodations,
        String aircraftID, String invoiceID, Boolean insurance) {
        this.id = id;
        this.luggageWeight = luggageWeight;
        this.seatNumber = seatNumber;
        this.accommodations = accommodations;
        this.aircraftID = aircraftID;
        this.invoiceID = invoiceID;
        this.insurance = insurance;
    }
}
