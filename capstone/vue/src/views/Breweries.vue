<template>
  <div class="breweries">
    <navigation></navigation>
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
<style scoped>
.breweries {
  background-color: hsl(13, 100%, 72%);
}

</style>