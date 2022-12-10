import axios from 'axios';

export default {

  listAll(breweryId) {
    //return axios.get(`/beers/${breweryId}?filter=all`);
    return axios.get(`/beers/?breweryId=${breweryId}&filter=all`);
  },

  listActive(breweryId) {
    //return axios.get(`/beers/${breweryId}?filter=active`);
    return axios.get(`/beers/?breweryId=${breweryId}&filter=active`);
  },

  get(beerId) {
    return axios.get(`/beers/${beerId}`);
  },

  create(beer) {
    return axios.post('/beers', beer);
  },

  update(beerId, beer) {
    return axios.put(`/beers/${beerId}`, beer);
  },

  delete(beerId) {
    return axios.delete(`/beers/${beerId}`);
  }

}