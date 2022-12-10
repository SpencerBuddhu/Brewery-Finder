<template>
  <div>
    <navigation></navigation>
    <h1>Manage Beers</h1>
    <brewer-beer-list></brewer-beer-list>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BrewerBeerList from '../components/BrewerBeerList.vue';

export default {
  name: 'manage-beers',
  components: {
    Navigation,
    BrewerBeerList
  }
}
</script>

<style>

</style>