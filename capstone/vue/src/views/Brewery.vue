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

export default {
  name: 'brewery',
  components: {
    Navigation,
    BreweryInfo
  },
  computed: {
    brewery() {
      return this.$store.state.breweries.find((b) => {
        return b.breweryId === this.$route.params.id;
      });
    }
  }
}
</script>