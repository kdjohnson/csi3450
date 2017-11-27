package edu.oakland.csi3450.service;

import java.util.List;
import edu.oakland.csi3450.models.*;

public interface IDB {
    List<Aircraft> getAircrafts();
    List<Flight> getFlights();
}
