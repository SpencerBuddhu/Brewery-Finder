<template>
  <div class="breweries">
    <navigation></navigation>
    <h1>Brewery List</h1>
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
  /* height: 100vh; */
  background-color: hsl(13, 100%, 72%);
  font-family: Ubuntu, sans-serif;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
h1 {
  font-size: 80px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  padding: 0 512px;
  border-radius: 16px;
}
</style>