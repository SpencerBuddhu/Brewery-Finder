<template>
  <div>
    <navigation></navigation>
    <h2>Add a Brewery</h2>
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
