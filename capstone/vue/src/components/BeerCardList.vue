<template>
  <div>
    <beer-card v-for="beer in this.$store.state.beers" v-bind:key="beer.beerId" v-bind:beer="beer"></beer-card>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js';
import BeerCard from '../components/BeerCard.vue';

export default {
  name: 'beer-card-list',
  components: {
    BeerCard
  },
  methods: {
    getBeers() {
      beerService.listActive(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_BEERS', response.data);
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
    }
  },
  created() {
    this.getBeers();
  }
}
</script>

<style>

</style>