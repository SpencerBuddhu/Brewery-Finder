<template>
  <div class="beer-detail">
    <navigation></navigation>
    <beer-info></beer-info>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BeerInfo from '../components/BeerInfo.vue';

export default {
  name: 'beer-detail',
  components: {
    Navigation,
    BeerInfo
  }
}
</script>

<style scoped>
.beer-detail {
  height: 100vh;
  background-color: hsl(13, 100%, 72%);
}
</style>