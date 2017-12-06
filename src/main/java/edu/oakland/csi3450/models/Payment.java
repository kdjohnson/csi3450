package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Payment {
    private String id;
    private String vendorName;
    private String csv;
    private String method;
    private String cardNumber;
    private Double cost;

    public Payment() {}

    public Payment(
        String id, String vendorName, String csv, String method, String cardNumber, Double cost) {
        this.id = id;
        this.vendorName = vendorName;
        this.csv = csv;
        this.method = method;
        this.cardNumber = cardNumber;
        this.cost = cost;
    }
}
