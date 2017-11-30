package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Membership {
    private String id;
    private Double discount;
    private String customerID;
    private String type;

    public Membership() {}

    public Membership(String id, Double discount, String customerID, String type) {
        this.id = id;
        this.discount = discount;
        this.customerID = customerID;
        this.type = type;
    }
}
