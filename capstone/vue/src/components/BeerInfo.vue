<template>
  <div>
    <h1>{{ beerName }}</h1>
    <img v-bind:src="beerImage" v-bind:alt="beerName">
    <div>
      <p>Beer Name:</p>
      <p>{{ beerName }}</p>
      <p>Beer Type:</p>
      <p>{{ beerType }}</p>
      <p>Beer ABV:</p>
      <p>{{ beerAbv }}</p>
      <p>Beer Description:</p>
      <p>{{ beerDescription }}</p>
    </div>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js';

export default {
  name: 'beer-info',
  data() {
    return {
      beerId: 0,
      breweryId: 0,
      beerName: '',
      beerType: '',
      beerAbv: 0.0,
      beerImage: '',
      beerDescription: ''
    }
  },
  methods: {
    getCurrentBeer() {
      beerService.get(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_CURRENT_BEER', response.data);
          this.beerId = response.data.beerId;
          this.breweryId = response.data.breweryId;
          this.beerName = response.data.beerName;
          this.beerType = response.data.beerType;
          this.beerAbv = response.data.beerAbv;
          this.beerImage = response.data.beerImage;
          this.beerDescription = response.data.beerDescription;
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
        });
    }
  },
  created() {
    this.getCurrentBeer();
  }
}
</script>

<style>

</style>