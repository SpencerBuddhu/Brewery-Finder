<template>
  <div>
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

<style>

</style>