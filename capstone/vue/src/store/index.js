import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    breweries: [],
    beerLovers: [],
    beers: [],
    currentBrewery: {},
    currentBeer: {},
    currentBeerReviews: [],
    breweryId: 0,
    brewerBrewery: {},
    brewerBeers: {}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      state.breweries = [];
      state.beerLovers = [];
      state.beers = [];
      state.breweryId = 0;
      state.brewerBrewery = {},
      state.brewerBeers = [],
      state.currentBrewery = {},
      state.currentBeer = {},
      axios.defaults.headers.common = {};
    },
    SET_BREWERIES(state, data) {
      state.breweries = data;
    },
    SET_BEER_LOVERS(state, data) {
      state.beerLovers = data;
    },
    SET_BEERS(state, data) {
      state.beers = data;
    },
    SET_BREWERY_ID(state, data) {
      state.breweryId = data;
    },
    SET_BREWER_BREWERY(state, data) {
      state.brewerBrewery = data;
    },
    SET_BREWER_BEERS(state, data) {
      state.brewerBeers = data;
    },
    SET_CURRENT_BREWERY(state, data) {
      state.currentBrewery = data;
    },
    SET_CURRENT_BEER(state, data) {
      state.currentBeer = data;
    },
    SET_CURRENT_BEER_REVIEWS(state, data) {
      state.currentBeerReviews = data;
    }
  }
})
