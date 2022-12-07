package com.techelevator.dao;


import com.techelevator.model.Address;
import com.techelevator.model.Brewery;
import com.techelevator.model.Hours;
import com.techelevator.model.NewBreweryDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> listBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM breweries WHERE is_active = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Brewery brewery = mapRowToBrewery(results);

            int addressId = results.getInt("address_id");
            brewery.setAddress(getBreweryAddress(addressId));

            int breweryId = results.getInt("brewery_id");
            brewery.setHours(getBreweryHours(breweryId));

            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = null;
        String sql = "SELECT brewery_id, brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, brewery_image \n" +
                "FROM breweries \n" +
                "WHERE is_active = true AND brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if (results.next()) {
            brewery = mapRowToBrewery(results);
        }
        return brewery;
    }

    @Override
    public void addBrewery(NewBreweryDto newBreweryDto) {
        String sqlAddresses = "INSERT INTO addresses (street_address, city, state, zipcode) VALUES (?, ?, ?, ?) RETURNING address_id;";
        int addressId = jdbcTemplate.queryForObject(sqlAddresses, int.class, newBreweryDto.getStreetAddress(), newBreweryDto.getCity(), newBreweryDto.getState(), newBreweryDto.getZipcode());
        String sqlBrewery = "INSERT INTO breweries (brewery_name, user_id, address_id, is_active) VALUES (?, ?, ?, true)";
        jdbcTemplate.update(sqlBrewery, newBreweryDto.getName(), newBreweryDto.getUserId(), addressId);
    }

    private Address getBreweryAddress(int addressId) {
        Address breweryAddress = new Address();
        String sql = "SELECT * FROM addresses WHERE address_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, addressId);
        if (results.next()) {
            breweryAddress = mapRowToAddress(results);
        }
        return breweryAddress;
    }

    private List<Hours> getBreweryHours(int breweryId) {
        List<Hours> breweryHours = new ArrayList<>();
        String sql = "SELECT * FROM hours " +
                "JOIN breweries_hours ON breweries_hours.hours_id = hours.hours_id " +
                "WHERE breweries_hours.brewery_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while (results.next()) {
            Hours hours = mapRowToHours(results);
            breweryHours.add(hours);
        }
        return breweryHours;
    }


    private Brewery mapRowToBrewery(SqlRowSet results) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(results.getInt("brewery_id"));
        brewery.setBreweryName(results.getString("brewery_name"));
        brewery.setUserId(results.getInt("user_id"));
        brewery.setWebsiteUrl(results.getString("website_url"));
        brewery.setEmailAddress(results.getString("email_address"));
        //brewery.setAddressId(results.getInt("address_id"));
        brewery.setPhoneNumber(results.getString("phone_number"));
        brewery.setBreweryHistory(results.getString("brewery_history"));
        brewery.setBreweryLogo(results.getString("brewery_logo"));
        brewery.setBreweryImage(results.getString("brewery_image"));
        //brewery.setActive(results.getBoolean("is_active"));

        return brewery;
    }

    private Address mapRowToAddress(SqlRowSet rowSet) {
        Address address = new Address();
        address.setAddressId(rowSet.getInt("address_id"));
        address.setStreetAddress(rowSet.getString("street_address"));
        address.setCity(rowSet.getString("city"));
        address.setState(rowSet.getString("state"));
        address.setZipcode(rowSet.getString("zipcode"));
        return address;
    }

    private Hours mapRowToHours(SqlRowSet rowSet) {
        Hours hours = new Hours();
        hours.setHoursId(rowSet.getInt("hours_id"));
        hours.setDay(getDayOfWeek(rowSet.getInt("day_id")));
        hours.setOpeningHour(LocalTime.parse(rowSet.getString("opening_hour")));
        hours.setClosingHour(LocalTime.parse(rowSet.getString("closing_hour")));
        return hours;
    }

    private String getDayOfWeek(int dayId) {
        String day = "";

        switch(dayId) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }

}
