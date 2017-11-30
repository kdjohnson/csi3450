package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Payment {
    private String id;
    private String vendorName;
    private Double vendorID;
    private String method;

    public Payment() {}

    public Payment(String id, String vendorName, String vendorID, String method) {
        this.id;
        this.vendorName;
        this.vendorID;
        this.method;
    }
}
