import axios from 'axios';

export default {

  listAll(breweryId) {
    return axios.get(`/beers/${breweryId}?filter=all`);
  },

  listActive(breweryId) {
    return axios.get(`/beers/${breweryId}?filter=active`);
  },

  get(breweryId, beerId) {
    return axios.get(`/beers/${breweryId}/${beerId}`);
  },

  create(breweryId, beer) {
    return axios.post(`/beers/${breweryId}`, beer);
  }

}