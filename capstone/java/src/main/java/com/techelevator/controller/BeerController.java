package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BeerController {

    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
    }


    @RequestMapping(path = "/beers/{breweryId}", method = RequestMethod.GET)
    public List<Beer> getBeersById (@PathVariable int breweryId) {
        return beerDao.listBeers(breweryId);
    }

    @RequestMapping(path = "/beer/{breweryId}/{beerId}", method = RequestMethod.GET)
    public Beer getBeerByBreweryId (@PathVariable int breweryId, @PathVariable int beerId) {
        return beerDao.getBeer(breweryId, beerId);
    }

    //TODO test to make sure this works
    @RequestMapping(path = "/beer/{breweryId}", method = RequestMethod.POST)
    public void addBeer(@RequestBody Beer beer, @PathVariable int breweryId) {
        beerDao.addBeer(beer, breweryId);
    }

}
