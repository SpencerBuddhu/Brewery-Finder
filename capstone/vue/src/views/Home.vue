<template>
  <div class="home">
    <navigation></navigation>
    <div class="container">
      <h1>Cheers!</h1>
      <div class="card-list">
        <div class="nav-card">
          <router-link v-bind:to="{ name: 'breweries' }">View all Breweries</router-link>
        </div>
        <div class="nav-card" v-if="isBrewer">
          <router-link v-bind:to="{ name: 'brewery', params: { id: breweryId } }">My Brewery</router-link>
        </div>
        <div class="nav-card" v-if="isBrewer">
          <router-link v-bind:to="{ name: 'manageBrewery' }">Manage Brewery</router-link>
        </div>
        <div class="nav-card" v-if="isBrewer">
          <router-link v-bind:to="{ name: 'manageBeers' }">Manage Beers</router-link>
        </div>
        <div class="nav-card" v-if="isAdmin">
          <router-link v-bind:to="{ name: 'addBrewery' }"> Add Brewery</router-link>
        </div>
      </div>
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

<style scoped>
.home {
  height: 100vh;
  background-color: hsl(13, 100%, 72%);
  font-family: Ubuntu, sans-serif;
}
.container {
  width: 1280px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
h1 {
  font-size: 80px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
}
.card-list {
  margin-top: 80px;
  display: flex;
  justify-content: space-around;
}
.nav-card {
  width: 256px;
  height: 256px;
  background-color: hsl(0, 0%, 100%);
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
a {
  text-decoration: none;
  font-size: 32px;
  color: hsl(208, 49%, 24%);
  text-align: center;
}
</style>