<template>
  <div class="container">
    <h1>Add Brewery</h1>
    <form class="form-card" v-on:submit.prevent="addBrewery">
      <h2>Brewery Information</h2>
      <div class="data-inputs">
        <label for="name">Brewery Name</label>
        <input type="text" class="form-control" v-model="brewery.name" required />
      </div>
      <div class="data-inputs">
        <label for="user">Select Brewer User</label>
        <select name="user" class="form-control" v-model.number="brewery.userId" required>
          <option value=""></option>
          <option v-for="user in this.$store.state.beerLovers" v-bind:key="user.id" v-bind:value="user.id">{{ user.username }}</option>
        </select>
      </div>
      <div class="data-inputs">
        <label for="streetAddress">Street Address</label>
        <input type="text" class="form-control" v-model="brewery.streetAddress" required />
      </div>
      <div class="data-inputs">
        <label for="city">City</label>
        <input type="text" class="form-control" v-model="brewery.city" required />
      </div>
      <div class="data-inputs">
        <label for="state">State</label>
        <input type="text" class="form-control" v-model="brewery.state" required />
      </div>
      <div class="data-inputs">
        <label for="zipcode">Zip Code</label>
        <input type="text" class="form-control" v-model="brewery.zipcode" required />
      </div>
      <div class="btn-container">
        <button class="btn blue">Submit</button>
        <button class="btn red" type="button" v-on:click="goBack">Cancel</button>
      </div>
      <p v-show="addBreweryError">{{ errorMessage }}</p>
    </form>
  </div>
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
          console.log(response);
          this.$store.commit('SET_BEER_LOVERS', response.data);
        } else {
          console.log(response);
        }
      })
    },
    addBrewery() {
      breweryService.create(this.brewery)
      .then(response => {
        if (response.status === 200) {
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
    },
    goBack() {
      this.$router.push({ name: 'home' });
    }
  },
  created() {
    this.getUsers();
  }

}
</script>

<style scoped>
.container {
  font-family: Ubuntu, sans-serif;
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
h2 {
  color: hsl(208, 49%, 24%);
  margin-bottom: 8px;
}
.form-card {
  width: 512px;
  margin: 24px auto 0 auto;
  display: flex;
  flex-direction: column;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  padding: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
  margin-bottom: 24px;
}
.data-inputs {
  display: flex;
  flex-direction: column;
  margin-bottom: 16px;
}
.data-inputs > label {
  font-size: 18px;
  color: hsl(208, 49%, 24%);
  padding: 8px 0;
}
.form-control {
  height: 32px;
  font-size: 16px;
  border: 1px solid hsl(208, 49%, 24%);
  padding-left: 8px;
}
.btn-container {
  width: 256px;
  display: flex;
  justify-content: space-evenly;
}
.btn {
  width: 96px;
  height: 48px;
  font-size: 16px;
  color: hsl(0, 0%, 100%);
  padding: 0 8px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  margin-top: 16px;
}

.blue {
  background-color: #0d6efd;
}
.red {
  background-color: #dc3545;
}
</style>