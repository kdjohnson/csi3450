package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Cancellation {
    private String reservationID;
    private String cancelDate;

    public Cancellation() {}

    public Cancellation(String reservationID, String cancelDate) {
        this.reservationID = reservationID;
        this.cancelDate = cancelDate;
    }
}
