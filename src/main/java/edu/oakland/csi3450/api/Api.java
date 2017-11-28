package edu.oakland.csi3450.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.oakland.csi3450.models.*;
import edu.oakland.csi3450.service.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/")
public class Api {
    @Autowired IDB db;
    @RequestMapping(value = "flights", produces = "application/json")
    public List<Flight> flights() {
        try {
            List<Flight> flights = db.getFlights();
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = "aircrafts", produces = "application/json")
    public List<Aircraft> aircrafts() {
        try {
            List<Aircraft> aircrafts = db.getAircrafts();
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }
}
