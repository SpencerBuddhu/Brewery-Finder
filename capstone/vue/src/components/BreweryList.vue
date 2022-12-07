<template>
  <div>
    <div v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.id">
      <img v-bind:src="brewery.breweryLogo" v-bind:alt="brewery.breweryName">
      <p><router-link v-bind:to="{ name: 'brewery', params: {id: 'brewery.id'}}">{{brewery.breweryName}}</router-link> {{brewery.city}}, {{brewery.state}}</p>
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
        if (response.status === 200) {
          //console.log(response.status);
          this.$store.commit('SET_BREWERIES', response.data);
        } else {
          console.log(response.status)
        }
        
      });
    }
  },
  created() {
    this.getBreweries();
  }
}
</script>