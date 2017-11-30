package edu.oakland.csi3450.service;

import edu.oakland.csi3450.models.*;
import edu.oakland.csi3450.service.*;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.jdbc.core.namedparam.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.ArrayList;

@Service
public class DB implements IDB {
    @Autowired private JdbcTemplate jdbcTemplate;

    public List<Aircraft> getAircrafts() {
        try {
            List<Aircraft> aircrafts = new ArrayList<Aircraft>();
            aircrafts.addAll(
                jdbcTemplate.query(Constants.GET_AIRCRAFTS, new Object[] {}, aircraftMapper));
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Aircraft> aircraftMapper = (rs, rowNum) -> {
        return new Aircraft(rs.getString("aircraft_id"), rs.getDouble("capacity"),
            rs.getString("flight_number"), rs.getDouble("routing_range"), rs.getString("name"));
    };

    public List<Flight> getFlights() {
        try {
            List<Flight> flights = new ArrayList<Flight>();
            flights.addAll(
                jdbcTemplate.query(Constants.GET_FLIGHTS, new Object[] {}, flightMapper));
            return flights;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Flight> flightMapper = (rs, rowNum) -> {
        return new Flight(rs.getString("flight_number"), rs.getInt("terminal_number"),
            rs.getString("gate"), rs.getInt("routing"), rs.getString("arrival"),
            rs.getString("departing"), rs.getInt("availability"), rs.getString("s"));
    };

    public List<Airport> getAirports() {
        try {
            List<Airport> airports = new ArrayList<Airport>();
            airports.addAll(
                jdbcTemplate.query(Constants.GET_AIRPORTS, new Object[] {}, airportMapper));
            return airports;
        } catch (Exception e) {
            throw e;
        }
    }

    RowMapper<Airport> airportMapper = (rs, rowNum) -> {
        return new Airport(rs.getString("airport_id"), rs.getString("a_name"),
            rs.getString("a_city"), rs.getString("a_country"));
    };

    public List<String> getAirportIDs() {
        try {
            List<String> airportIDs =
                jdbcTemplate.queryForList(Constants.GET_AIRPORT_IDS, String.class);
            return airportIDs;
        } catch (Exception e) {
            throw e;
        }
    }
}
