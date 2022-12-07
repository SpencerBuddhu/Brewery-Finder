package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {
    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> findBreweries() {
        List <Brewery> breweries = breweryDao.listBreweries();
        return breweries;
        }

    @RequestMapping(path = "/breweries/{breweryId}", method = RequestMethod.GET)
    public Brewery getBreweryById (@PathVariable int breweryId) {
        return breweryDao.getBreweryById(breweryId);
    }

    @RequestMapping(path = "/breweries", method = RequestMethod.POST)
    public void addBrewery(@RequestBody Brewery newBrewery) {
        breweryDao.addBrewery(newBrewery);
    }

}



