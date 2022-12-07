import axios from 'axios';

export default {

  list() {
    return axios.get('/breweries');
  },

  get(id) {
    return axios.get(`/breweries/${id}`);
  },

  create(breweryDto) {
    return axios.post('/breweries', breweryDto);
  }

}