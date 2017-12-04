package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Payment {
    private String id;
    private String vendorName;
    private int vendorID;
    private String method;

    public Payment() {}

    public Payment(String id, String vendorName, int vendorID, String method) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorID = vendorID;
        this.method = method;
    }
}
