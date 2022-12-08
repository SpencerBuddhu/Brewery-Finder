<template>
  <div>
    <navigation></navigation>
    <brewery-info v-bind:brewery="brewery"></brewery-info>
    <router-link v-bind:to="{ name: 'breweries'}">Back to Breweries</router-link>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BreweryInfo from '../components/BreweryInfo.vue';
import breweryService from '../services/BreweryService.js';

export default {
  name: 'brewery',
  components: {
    Navigation,
    BreweryInfo
  },
  computed: {
    brewery() {
      return this.$store.state.currentBrewery;
    }
  },
  methods: {
    getCurrentBrewery() {
      breweryService.get(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_CURRENT_BREWERY', response.data);
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
    this.getCurrentBrewery();
  }
}
</script>