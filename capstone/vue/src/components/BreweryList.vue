<template>
  <div>
    <div v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.id">
      <img v-bind:src="brewery.logo" v-bind:alt="brewery.name">
      <p>{{brewery.name}} {{brewery.city}}, {{brewery.state}}</p>
    </div>
  </div>
</template>
<script>
import breweryService from '../services/BreweryService.js';

export default {
  name: 'brewery-list',
  methods: {
    getBreweries() {
      breweryService.list()
      .then(response => {
        this.$store.commit('SET_BREWERIES', response.data);
      });
    }
  },
  created() {
    this.getBreweries();
  }
}
</script>