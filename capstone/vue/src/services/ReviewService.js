import axios from 'axios';

export default {

  list(beerId) {
    return axios.get(`/beers/${beerId}/reviews`);
  },

  create(review) {
    return axios.post('/reviews', review);
  }
  
}