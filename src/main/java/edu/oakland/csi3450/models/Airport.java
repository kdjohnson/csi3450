package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Airport {
    private String airportID;
    private String airportName;
    private String airportCity;
    private String airportCountry;

    public Airport() {}

    public Airport(
        String airportID, String airportName, String airportCity, String airportCountry) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCity;
    }
}
