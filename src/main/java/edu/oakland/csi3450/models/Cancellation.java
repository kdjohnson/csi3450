package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Cancellation {
    private String reservationID;
    private Date cancelDate;

    public Cancellation() {}

    public Cancellation(String reservationID, Date cancelDate) {
        this.reservationID = reservationID;
        this.cancelDate = cancelDate;
    }
}
