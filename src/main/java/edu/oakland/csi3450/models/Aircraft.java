package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Aircraft {
    private String aircraftID;
    private double capacity;
    private boolean delayed;
    private String flightNumber;
    private double routing_range;
    private String name;

    public Aircraft() {}

    public Aircraft(String aircraftID, double capacity, boolean delayed, String flightNumber,
        double routing_range, String name) {
        this.aircraftID = aircraftID;
        this.capacity = capacity;
        this.delayed = delayed;
        this.flightNumber = flightNumber;
        this.routing_range = routing_range;
        this.name = name;
    }
}
