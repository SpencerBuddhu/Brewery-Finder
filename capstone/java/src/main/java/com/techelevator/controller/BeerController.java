package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class BeerController {

    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
    }


    //TODO Works but maybe fix it up to look a bit cleaner
    @RequestMapping(path = "/beers/{breweryId}", method = RequestMethod.GET)
    public List<Beer> getBeersById (@PathVariable int breweryId, @RequestParam(required = false) String filter) {
        String active = "active";
        String all = "all";
        if (Objects.equals(filter, active)) {
            return beerDao.listActiveBeers(breweryId);
        } else if (Objects.equals(filter, all)) {
            return beerDao.listBeers(breweryId);
        }
        else return null;
    }

    @RequestMapping(path = "/beers/{breweryId}/{beerId}", method = RequestMethod.GET)
    public Beer getBeerByBreweryId (@PathVariable int breweryId, @PathVariable int beerId) {
        return beerDao.getBeer(breweryId, beerId);
    }

    @RequestMapping(path = "/beers/{breweryId}", method = RequestMethod.POST)
    public void addBeer(@RequestBody Beer beer, @PathVariable int breweryId) {
        beerDao.addBeer(beer, breweryId);
    }


    @RequestMapping(path = "/beers/{beerId}", method = RequestMethod.DELETE)
    public void deleteBeer(@PathVariable int beerId) {
        beerDao.deleteBeer(beerId);
    }

    @RequestMapping(path = "/beers/{beerId}", method = RequestMethod.POST)
    public void activateBeer(@PathVariable int beerId) {
        beerDao.activateBeer(beerId);
    }

}
