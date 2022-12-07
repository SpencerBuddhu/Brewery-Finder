<template>
  <div>
    <h2>Brewery List</h2>
    <brewery-list></brewery-list>
  </div>
</template>

<script>
import BreweryList from '../components/BreweryList.vue';

export default {
  name: 'breweries',
  components: {
    BreweryList
  }
}
</script>