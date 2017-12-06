package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Flight {
    private String flightNumber;
    private String aircraftID;
    private int terminalNumber;
    private String gate;
    private int routing;
    private String arrival;
    private String departing;
    private int availability;
    private String status;
    private Double cost;
    private String departTime;
    private String arrivalTime;

    public Flight() {}

    public Flight(String flightNumber, String aircraftID, int terminalNumber, String gate,
        int routing, String arrival, String departing, int availability, String status, Double cost,
        String departTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.aircraftID = aircraftID;
        this.terminalNumber = terminalNumber;
        this.gate = gate;
        this.routing = routing;
        this.arrival = arrival;
        this.departing = departing;
        this.availability = availability;
        this.status = status;
        this.cost = cost;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }
}
