package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Flight {
    private String flightNumber;
    private int terminalNumber;
    private String gate;
    private int routing;
    private String arrival;
    private String departing;

    public Flight() {}

    public Flight(String flightNumber, int terminalNumber, String gate, int routing, String arrival,
        String departing) {
        this.flightNumber = flightNumber;
        this.terminalNumber = terminalNumber;
        this.gate = gate;
        this.routing = routing;
        this.arrival = arrival;
        this.departing = departing;
    }
}
