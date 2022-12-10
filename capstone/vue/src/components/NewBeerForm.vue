<template>
  <form v-on:submit.prevent="addBeer">
    <div>
      <label for="name">Beer Name</label>
      <input type="text" v-model="beer.beerName" />
    </div>
    <div>
      <label for="type">Beer Type</label>
      <input type="text" v-model="beer.beerType" />
    </div>
    <div>
      <label for="abv">Beer ABV</label>
      <input type="number" step="0.1" v-model="beer.beerAbv" />
    </div>
    <div>
      <label for="imageLink">Beer Image Link</label>
      <input type="text" v-model="beer.beerImage" />
    </div>
    <div>
      <label for="description">Beer Description</label>
      <textarea name="description" cols="30" rows="10" v-model.lazy="beer.beerDescription"></textarea>
    </div>
    <div>
      <label for="active">Beer Status</label>
      <input type="checkbox" v-model="beer.active">
    </div>
    <button>Submit</button>
    <p v-show="addBeerError">{{ errorMessage }}</p>
  </form>
</template>

<script>
import beerService from '../services/BeerService.js';

export default {
  name: 'new-beer-form',
  data() {
    return {
      beer: {
        beerId: 0,
        breweryId: this.$store.state.breweryId,
        beerName: '',
        beerType: '',
        beerAbv: 0.0,
        beerImage: '',
        beerDescription: '',
        active: false
      },
      addBeerError: false,
      errorMessage: ''
    }
  },
  methods: {
    addBeer() {
      beerService.create(this.beer)
      .then(response => {
        if (response.status === 200) {
          this.addBeerError = false;
          this.resetBeer();
          this.$router.push({ name: 'manageBeers' });
        }
      })
      .catch(error => {
        this.addBeerError = true;
        if (error.response) {
          this.errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
        } else if (error.request) {
          this.errorMessage = 'Error submitting form. Server could not be reached.';
        } else {
          this.errorMessage = 'Error submitting form. Request could not be created.';
        }
      });
    },
    resetBeer() {
      this.beer = {
        beerId: 0,
        beerName: '',
        beerType: '',
        beerAbv: 0.0,
        beerImage: '',
        beerDescription: '',
        active: false
      };
    }
  }
}
</script>

<style>

</style>