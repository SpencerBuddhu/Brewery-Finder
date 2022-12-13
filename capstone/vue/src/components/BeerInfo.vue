<template>
  <div class="container">
    <h1>{{ beerName }}</h1>
    <div class="beer-info">
      <img class="beer-image" v-bind:src="beerImage" v-bind:alt="beerName">
      <div class="beer-details">
        <h2>Beer Information</h2>
        <div class="beer-data">
          <p class="beer-property">Brewery Name:</p>
          <p class="beer-value">{{ this.$store.state.currentBrewery.breweryName }}</p>
        </div>
        <div class="beer-data">
          <p class="beer-property">Beer Name:</p>
          <p class="beer-value">{{ beerName }}</p>
        </div>
        <div class="beer-data">
          <p class="beer-property">Beer Type:</p>
          <p class="beer-value">{{ beerType }}</p>
        </div>
        <div class="beer-data">
          <p class="beer-property">Beer ABV:</p>
          <p class="beer-value">{{ beerAbv }}&#37;</p>
        </div>
        <div class="beer-data">
          <p class="beer-property">Beer Description:</p>
          <p class="beer-value">{{ beerDescription }}</p>
        </div>
        <div class="beer-data">
          <p class="beer-property">Average Rating:</p>
          <p class="beer-value" v-if="averageRating">{{ averageRating }}/5</p>
          <p class="beer-value" v-else>No Ratings Available</p>
        </div>
      </div>
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
      beerDescription: '',
      averageRating: 0
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
          this.averageRating = response.data.averageRating;
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

<style scoped>
.container {
  font-family: Ubuntu, sans-serif;
  width: 1280px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
h1 {
  font-size: 80px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
}
h2 {
  font-size: 32px;
  text-align: center;
}
.beer-info {
  display: flex;
  justify-content: space-around;
  margin: 16px 0;
}
.beer-image {
  width: 512px;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
.beer-details {
  width: 512px;
  background-color: hsl(0, 0%, 100%);
  color: hsl(207, 13%, 34%);
  border-radius: 16px;
  padding: 16px 32px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
.beer-data {
  margin: 8px 0;
}
.beer-property {
  font-size: 24px;
  font-weight: bold;
}
</style>