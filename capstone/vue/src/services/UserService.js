import axios from 'axios';

export default {

  list() {
    return axios.get('/users');
  },

  getBrewerBreweryId(userId) {
    return axios.get(`/users/${userId}`);
  }

}