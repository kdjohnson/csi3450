package edu.oakland.csi3450.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.oakland.csi3450.service.IDB;
import java.util.List;

import edu.oakland.csi3450.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

@Controller
public class ViewController {
    @Autowired IDB db;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("flight", new Flight());
        return "index";
    }

    @RequestMapping("/customer")
    public String customer(Model model, @ModelAttribute("contact") Contact contact) {
        db.insertContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(),
            contact.getEmail(), contact.getRelationship());
        return "customer";
    }

    @RequestMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @RequestMapping("/payment")
    public String payment(Model model, @ModelAttribute("flight") Flight flight) {
        model.addAttribute("flight", db.getFlight(flight.getFlightNumber()));
        model.addAttribute("aircraftID", db.getFlight(flight.getFlightNumber()).getAircraftID());
        model.addAttribute("payment", new Payment());
        return "payment";
    }

    @RequestMapping("/reservation")
    public String reservation(Model model, @ModelAttribute("payment") Payment payment) {
        db.insertPayment(payment.getVendorName(), payment.getCsv(), payment.getMethod(),
            payment.getCardNumber(), payment.getCost());

        Random rand = new Random();
        int n = rand.nextInt(15) + 1;
        Payment lastPayment = db.getLatestPayment();
        model.addAttribute("flightNumber", payment.getId());
        model.addAttribute("seat", Integer.toString(n));
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("invoiceID", lastPayment.getId());
        return "reservation";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        List<String> names = db.getTableNames();
        List<Flight> flights = db.getFlights();
        model.addAttribute("names", names);
        model.addAttribute("flights", flights);
        return "admin";
    }

    @RequestMapping("/flight")
    public String flight(Model model, @ModelAttribute("flight") Flight flight) {
        List<Flight> flights = db.getFlights(flight.getArrival(), flight.getDeparting());
        model.addAttribute("flights", flights);
        return "flight";
    }

    @RequestMapping("/end")
    public String end(@ModelAttribute("reservation") Reservation reservation) {
        db.insertReservation(reservation.getSeatNumber(), reservation.getAccommodations(),
            reservation.getFlightNumber(), reservation.getInvoiceID(), reservation.getInsurance());
        return "end";
    }
}
