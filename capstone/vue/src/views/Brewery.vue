<template>
  <div class="brewery">
    <navigation></navigation>
    <brewery-info></brewery-info>
    <beer-card-list></beer-card-list>
    <!-- <router-link v-bind:to="{ name: 'breweries'}">Back to Breweries</router-link> -->
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BreweryInfo from '../components/BreweryInfo.vue';
import BeerCardList from '../components/BeerCardList.vue'

export default {
  name: 'brewery',
  components: {
    Navigation,
    BreweryInfo,
    BeerCardList
  }
  
}
</script>

<style scoped>
.brewery {
  background-color: hsl(13, 100%, 72%);
}
</style>