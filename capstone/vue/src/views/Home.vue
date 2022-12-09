<template>
  <div class="home">
    <navigation></navigation>
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div>
      <router-link v-bind:to="{ name: 'breweries' }">View all Breweries</router-link>
    </div>
    <div v-if="isBrewer">
      <router-link v-bind:to="{ name: 'brewery', params: { id: breweryId } }">My Brewery</router-link>
    </div>
    <div v-if="isBrewer">
      <router-link v-bind:to="{ name: 'manageBrewery' }">Manage Brewery</router-link>
    </div>
    <div v-if="isBrewer">
      <router-link v-bind:to="{ name: 'manageBeers' }">Manage Beers</router-link>
    </div>
    <div v-if="isAdmin">
      <router-link v-bind:to="{ name: 'addBrewery' }"> Add Brewery</router-link>
    </div>

  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import userService from '../services/UserService.js';

export default {
  name: "home",
  components: {
    Navigation
  },
  computed: {
    isAdmin() {
      return this.$store.state.user.authorities[0].name === 'ROLE_ADMIN';
    },
    isBrewer() {
      return this.$store.state.user.authorities[0].name === 'ROLE_BREWER';
    },
    breweryId() {
      return this.$store.state.breweryId;
    }
  },
  methods: {
    getBreweryId() {
      if (this.isBrewer) {
        userService.getBrewerBreweryId(this.$store.state.user.id)
        .then(response => {
          if (response.status === 200) {
            this.$store.commit('SET_BREWERY_ID', response.data);
          } else {
            console.log(response.status);
          }
        })
        .catch(error => {
          let errorMessage;
          if (error.response) {
            errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
          } else if (error.request) {
            errorMessage = 'Error submitting form. Server could not be reached.';
          } else {
            errorMessage = 'Error submitting form. Request could not be created.';
          }
          console.log(errorMessage);
        })
      }
    }
  },
  created() {
    this.getBreweryId();
  }
};
</script>
