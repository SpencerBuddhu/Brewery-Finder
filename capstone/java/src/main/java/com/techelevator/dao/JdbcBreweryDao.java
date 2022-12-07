package com.techelevator.dao;


import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
        String sql = "SELECT brewery_id, brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo\n" +
                "FROM breweries\n" +
                "WHERE is_active = true";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = null;
        String sql = "SELECT brewery_id, brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo \n" +
                "FROM breweries \n" +
                "WHERE is_active = true AND brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if (results.next()) {
            brewery = mapRowToBrewery(results);
        }
        return brewery;
    }

    @Override
    public void addBrewery(Brewery newBrewery) {
        String sql = "INSERT INTO breweries (brewery_id, brewery_name, user_id, website_url, email_address, address_id, phone_number, brewery_history, brewery_logo, is_active) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, newBrewery.getBreweryId(), newBrewery.getBreweryName(), newBrewery.getUserId(),
                newBrewery.getWebsiteUrl(), newBrewery.getEmailAddress(), newBrewery.getAddressId(),
                newBrewery.getPhoneNumber(), newBrewery.getBreweryHistory(), newBrewery.getBreweryLogo(),
                newBrewery.getActive());
    }


    private Brewery mapRowToBrewery(SqlRowSet results) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(results.getInt("brewery_id"));
        brewery.setBreweryName(results.getString("brewery_name"));
        brewery.setUserId(results.getInt("user_id"));
        brewery.setWebsiteUrl(results.getString("website_url"));
        brewery.setEmailAddress(results.getString("email_address"));
        brewery.setAddressId(results.getInt("address_id"));
        brewery.setPhoneNumber(results.getString("phone_number"));
        brewery.setBreweryHistory(results.getString("brewery_history"));
        brewery.setBreweryLogo(results.getString("brewery_logo"));
        brewery.setActive(results.getBoolean("is_active"));

        return brewery;
    }

}
