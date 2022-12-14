<template>
  <div class="manage-beers">
    <navigation></navigation>
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

<style scoped>
.manage-beers {
  min-height: 100vh;
  background-color: hsl(13, 100%, 72%);
}
</style>