<template>
  <div>
    <navigation></navigation>
    <h1>Manage Brewery</h1>
    <p>Number of Beers: {{brewerBeers.length}}</p>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import beerService from '../services/BeerService.js';

export default {
  name: 'manage-beers',
  components: {
    Navigation
  },
  computed: {
    breweryId() {
      return this.$store.state.breweryId;
    },
    brewerBeers() {
      return this.$store.state.brewerBeers;
    }
  },
  methods: {
    getBrewerBeers() {
      beerService.list(this.breweryId)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_BREWER_BEERS', response.data);
        } else {
          console.log(response.status);
        }
      })
      .catch(error => {
          let errorMessage;
          if (error.response) {
            errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
          } else if (error.request) {
            errorMessage = 'Error submitting form. Server could not be reached.';
          } else {
            errorMessage = 'Error submitting form. Request could not be created.';
          }
          console.log(errorMessage);
        })
    }
  },
  created() {
    this.getBrewerBeers();
  }
}
</script>

<style>

</style>