<template>
  <form v-on:submit.prevent="addBrewery">
    <div>
      <label for="name">Brewery Name</label>
      <input type="text" v-model="brewery.name" />
    </div>
    <div>
      <label for="user">Select Brewer User</label>
      <select name="user" v-model.number="brewery.userId">
        <option value=""></option>
        <option v-for="user in this.$store.state.users" v-bind:key="user.id" v-bind:value="user.id">{{ user.username }}</option>
      </select>
    </div>
    <div>
      <label for="streetAddress">Street Address</label>
      <input type="text" v-model="brewery.streetAddress" />
    </div>
    <div>
      <label for="city">City</label>
      <input type="text" v-model="brewery.city" />
    </div>
    <div>
      <label for="state">State</label>
      <input type="text" v-model="brewery.state" />
    </div>
    <div>
      <label for="zipcode">Zip Code</label>
      <input type="text" v-model="brewery.zipcode" />
    </div>
    <button>Submit</button>
    <p v-show="addBreweryError">{{ errorMessage }}</p>
  </form>
</template>

<script>
import userService from '../services/UserService';
import breweryService from '../services/BreweryService';

export default {
  name: 'new-brewery-form',
  data() {
    return {
      brewery: {
        name: '',
        userId: 0,
        streetAddress: '',
        city: '',
        state: '',
        zipcode: ''
      },
      addBreweryError: false,
      errorMessage: ''
    }
  },
  methods: {
    getUsers() {
      userService.list()
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_USERS', response.data);
        }
      })
    },
    addBrewery() {
      breweryService.create(this.brewery)
      .then(response => {
        if (response.status === 201) {
          this.addBreweryError = false;
          this.resetBrewery();
          this.$router.push({ name: 'breweries' });
        }
      })
      .catch(error => {
        this.addBreweryError = true;
        if (error.response) {
          this.errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
        } else if (error.request) {
          this.errorMessage = 'Error submitting form. Server could not be reached.';
        } else {
          this.errorMessage = 'Error submitting form. Request could not be created.';
        }
      });
    },
    resetBrewery() {
      this.brewery = {
        name: '',
        user: 0,
        streetAddress: '',
        city: '',
        state: '',
        zipcode: ''
      };
    }
  },
  created() {
    this.getUsers();
  }

}
</script>

<style>

</style>