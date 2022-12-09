import axios from 'axios';

export default {

  list(breweryId) {
    return axios.get(`/beers/${breweryId}`);
  },

  get(breweryId, beerId) {
    return axios.get(`/beers/${breweryId}/${beerId}`);
  },

  create(breweryId, beer) {
    return axios.post(`/beers/${breweryId}`, beer);
  }

}