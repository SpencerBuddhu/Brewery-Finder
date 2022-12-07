package com.techelevator.model;

public class Brewery {

    private int breweryId;
    private String breweryName;
    private int userId;
    private String websiteUrl;
    private String emailAddress;
    private int addressId;
    private String phoneNumber;
    private String breweryHistory;
    private String breweryLogo;
    private Boolean isActive;
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    public Brewery(int breweryId, String breweryName, int userId, String websiteUrl, String emailAddress, int addressId, String phoneNumber, String breweryHistory, String breweryLogo, Boolean isActive, String streetAddress, String city, String state, int zipcode) {
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.userId = userId;
        this.websiteUrl = websiteUrl;
        this.emailAddress = emailAddress;
        this.addressId = addressId;
        this.phoneNumber = phoneNumber;
        this.breweryHistory = breweryHistory;
        this.breweryLogo = breweryLogo;
        this.isActive = isActive;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Brewery(){}


    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBreweryHistory() {
        return breweryHistory;
    }

    public void setBreweryHistory(String breweryHistory) {
        this.breweryHistory = breweryHistory;
    }

    public String getBreweryLogo() {
        return breweryLogo;
    }

    public void setBreweryLogo(String breweryLogo) {
        this.breweryLogo = breweryLogo;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}