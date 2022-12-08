<template>
  <div>
    <navigation></navigation>
    <h2>Brewery List</h2>
    <brewery-list></brewery-list>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BreweryList from '../components/BreweryList.vue';

export default {
  name: 'breweries',
  components: {
    Navigation,
    BreweryList
  }
}
</script>