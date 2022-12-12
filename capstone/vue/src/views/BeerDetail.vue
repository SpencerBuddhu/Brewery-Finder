<template>
  <div class="beer-detail">
    <navigation></navigation>
    <beer-info></beer-info>
    <review-card-list></review-card-list>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import BeerInfo from '../components/BeerInfo.vue';
import ReviewCardList from '../components/ReviewCardList.vue';

export default {
  name: 'beer-detail',
  components: {
    Navigation,
    BeerInfo,
    ReviewCardList
  }
}
</script>

<style scoped>
.beer-detail {
  /* height: 100vh; */
  background-color: hsl(13, 100%, 72%);
}
</style>