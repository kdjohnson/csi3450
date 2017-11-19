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

public class DB implements IDB {
    @Autowired private JdbcTemplate jdbcTemplate;

    public List<Aircraft> getAircraft() {
        RowMapper<Aircraft> rowMapper = (rs, rowNum) -> {
            return new Aircraft(rs.getString("aircraft_id"), rs.getDouble("capacity"),
                rs.getBoolean("delayed"), rs.getString("flight_number"),
                rs.getDouble("routing_range"), rs.getString("name"));
        };

        try {
            List<Aircraft> aircrafts =
                jdbcTemplate.query(Constants.GET_AIRCRAFTS, new Object[] {}, rowMapper);
            return aircrafts;
        } catch (Exception e) {
            throw e;
        }
    }
}
