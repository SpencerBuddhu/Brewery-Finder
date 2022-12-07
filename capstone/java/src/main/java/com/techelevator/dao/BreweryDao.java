package com.techelevator.dao;


import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> listBreweries();

    Brewery getBreweryById(int breweryId);

    void addBrewery(Brewery newBrewery);

}
