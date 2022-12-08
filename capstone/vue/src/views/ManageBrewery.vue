<template>
  <div>
    <navigation></navigation>
    <h1>Manage Brewery</h1>
    <h2>{{ brewerBrewery.breweryName }}</h2>
    <update-brewery-form></update-brewery-form>
    <update-brewery-address></update-brewery-address>
    <update-brewery-hours></update-brewery-hours>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import UpdateBreweryForm from '../components/UpdateBreweryForm.vue';
import UpdateBreweryAddress from '../components/UpdateBreweryAddress.vue';
import UpdateBreweryHours from '../components/UpdateBreweryHours.vue';
import breweryService from '../services/BreweryService.js';

export default {
  name: 'manage-brewery',
  components: {
    Navigation,
    UpdateBreweryForm,
    UpdateBreweryAddress,
    UpdateBreweryHours
  },
  computed: {
    breweryId() {
      return this.$store.state.breweryId;
    },
    brewerBrewery() {
      return this.$store.state.brewerBrewery;
    }
  },
  methods: {
    getBrewerBrewery() {
      breweryService.get(this.breweryId)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_BREWER_BREWERY', response.data);
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
    this.getBrewerBrewery();
  }
}
</script>

<style>

</style>