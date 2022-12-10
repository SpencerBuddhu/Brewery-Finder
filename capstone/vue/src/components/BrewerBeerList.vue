<template>
  <div id="myBeers">
    <button v-on:click="addBeer">Add a Beer</button>
    <div v-for="beer in this.$store.state.brewerBeers" v-bind:key="beer.beerId">
      <h3>{{ beer.beerName }}</h3>
      <button v-on:click="viewBeer(beer.beerId)">View</button>
      <button v-show="beer.active" v-on:click="toggleActive(beer)">Active</button>
      <button v-show="!beer.active" v-on:click="toggleActive(beer)">Inactive</button>
    </div>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js';

export default {
  name: 'brewer-beer-list',
  methods: {
    getBrewerBeers() {
      beerService.listAll(this.$store.state.breweryId)
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
            errorMessage = 'Server could not be reached.';
          } else {
            errorMessage = 'Request could not be created.';
          }
          console.log(errorMessage);
        })
    },
    toggleActive(beer) {
      beer.active = !beer.active;
      beerService.delete(beer.beerId)
      .then(response => {
        if (response.status === 200) {
          console.log(response.status);
        } else {
          console.log(response.status);
        }
      })
      .catch(error => {
          let errorMessage;
          if (error.response) {
            errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
          } else if (error.request) {
            errorMessage = 'Server could not be reached.';
          } else {
            errorMessage = 'Request could not be created.';
          }
          console.log(errorMessage);
        });
    },
    viewBeer(beerId) {
      this.$router.push({ name: 'beers', params: { id: beerId }});
    },
    addBeer() {
      this.$router.push({ name: 'addBeer' });
    }
  },
  created() {
    this.getBrewerBeers();
  }
}
</script>

<style>

</style>