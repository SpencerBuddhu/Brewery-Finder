import axios from 'axios';

export default {

  list() {
    return axios.get('/users');
  },

  getBrewerBreweryId() {
    return axios.get('/users/breweryId');
  }

}