<template>
  <div class="home">
    <navigation></navigation>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div>
      <router-link v-bind:to="{ name: 'breweries' }">View all Breweries</router-link>
    </div>
    <div v-if="this.$store.state.user.authorities[0].name === 'ROLE_ADMIN'">
      <router-link v-bind:to="{ name: 'addBrewery' }"> Add Brewery</router-link>
    </div>

  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';

export default {
  name: "home",
  components: {
    Navigation
  }
};
</script>
