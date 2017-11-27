package edu.oakland.csi3450.service;

public class Constants {
    public static final String GET_FLIGHTS =
        new String("SELECT * FROM flight").replaceAll("\\s+", " ");
    public static final String GET_AIRCRAFTS =
        new String("SELECT * FROM aircraft").replaceAll("\\s+", " ");
}
