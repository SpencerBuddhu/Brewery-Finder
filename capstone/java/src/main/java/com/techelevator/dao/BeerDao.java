package com.techelevator.dao;

import com.techelevator.model.Beer;

import java.util.List;

public interface BeerDao {

    List<Beer> listBeers(int breweryId);

    Beer getBeer(int breweryId, int beerId);

    void addBeer(Beer beer, int breweryId);

    void deleteBeer(int beerId);


}
