package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Aircraft {
    private String aircraftID;
    private double capacity;
    private double routing_range;
    private String name;

    public Aircraft() {}

    public Aircraft(String aircraftID, double capacity, double routing_range, String name) {
        this.aircraftID = aircraftID;
        this.capacity = capacity;
        this.routing_range = routing_range;
        this.name = name;
    }
}
