<template>
  <div class="new-brewery">
    <navigation></navigation>
    <new-brewery-form></new-brewery-form>
  </div>
</template>
<script>
import Navigation from '../components/Navigation.vue';
import NewBreweryForm from '../components/NewBreweryForm.vue';

export default {
  name: 'new-brewery',
  components: {
    Navigation,
    NewBreweryForm
  }
}
</script>
<style scoped>
.new-brewery {
  height: 100vh;
  background-color: hsl(13, 100%, 72%);
}
</style>