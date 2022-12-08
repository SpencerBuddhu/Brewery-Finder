package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Beer> listBeers(int breweryId) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT * FROM beers  \n" +
                "JOIN breweries_beers ON breweries_beers.beer_id = beers.beer_id\n" +
                "WHERE breweries_beers.brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            beers.add(beer);
        }
        return beers;
    }

    @Override
    public Beer getBeer(int breweryId, int beerId) {
        Beer beer = new Beer();
        String sql = "SELECT * FROM beers  \n" +
                "JOIN breweries_beers ON breweries_beers.beer_id = beers.beer_id\n" +
                "WHERE breweries_beers.brewery_id = ? AND breweries_beers.beer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId, beerId);
        if (results.next()) {
            beer = mapRowToBeer(results);
        }
        return beer;
    }

    @Override
    public void addBeer(Beer beer, int breweryId) {
        String sqlBeer = "INSERT INTO beers (beer_name, beer_description, image, abv, beer_type, is_active)\n" +
                "VALUES ('?', '?', '?', ?, '?', true) RETURNING beer_id";
        int newBeerId = jdbcTemplate.queryForObject(sqlBeer, int.class, beer.getBeerName(), beer.getBeerDescription(), beer.getBeerImage(), beer.getBeerAbv(), beer.getBeerAbv(), beer.getBeerType());
        String sqlBeerBrewery = "INSERT INTO breweries_beers (brewery_id, beer_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlBeerBrewery, breweryId, newBeerId);
    }

    @Override
    public void deleteBeer(int beerId) {

    }



    private Beer mapRowToBeer(SqlRowSet results) {
        Beer beer = new Beer();
        beer.setBeerId(results.getInt("beer_id"));
        beer.setBeerName(results.getString("beer_name"));
        beer.setBeerDescription(results.getString("beer_description"));
        beer.setBeerImage(results.getString("image"));
        beer.setBeerAbv(results.getDouble("abv"));
        beer.setBeerType(results.getString("beer_type"));
        beer.setActive(results.getBoolean("is_active"));
        return beer;
    }


}
