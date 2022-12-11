<template>
  <div class="brewery-list">
    <h1>Brewery List</h1>
    <div class="brewery-card-list">
      <div class="brewery-card" v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.breweryId">
        <img v-bind:src="brewery.breweryLogo" v-bind:alt="brewery.breweryName" v-on:click="goToBrewery(brewery.breweryId)">
        <router-link v-bind:to="{ name: 'brewery', params: {id: brewery.breweryId}}">{{brewery.breweryName}}</router-link>
        <p class="location">{{brewery.address.city}}, {{brewery.address.state}}</p>
      </div>
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
          this.$store.commit('SET_BREWERIES', response.data);
        } else {
          console.log(response.status)
        }
        
      });
    },
    goToBrewery(breweryId) {
      this.$router.push({ name: 'brewery', params: { id: breweryId }});
    }
  },
  created() {
    this.getBreweries();
  }
}
</script>
<style scoped>
.brewery-list {
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
.brewery-card-list {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.brewery-card {
  width: 1024px;
  height: 256px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
  padding: 8px 16px;
  margin: 24px 0;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
img {
  width: 240px;
  height: 240px;
  border-radius: 16px;
}
img:hover {
  cursor: pointer;
}
a {
  text-decoration: none;
  font-size: 32px;
  color: hsl(208, 49%, 24%);
}
.location {
  font-size: 20px;
  color: hsl(208, 49%, 24%);
  padding-right: 16px;
}
</style>