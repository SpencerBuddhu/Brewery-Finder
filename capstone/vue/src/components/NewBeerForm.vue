<template>
  <div class="container">
    <h1>Add a Beer</h1>
    <form class="form-card" v-on:submit.prevent="addBeer">
      <h2>Beer Information</h2>
      <div class="data-inputs">
        <label for="name">Beer Name</label>
        <input type="text" class="form-control" v-model="beer.beerName" required />
      </div>
      <div class="data-inputs">
        <label for="type">Beer Type</label>
        <input type="text" class="form-control" v-model="beer.beerType" required />
      </div>
      <div class="data-inputs">
        <label for="abv">Beer ABV</label>
        <input type="number" class="form-control" step="0.1" v-model="beer.beerAbv" required />
      </div>
      <div class="data-inputs">
        <label for="imageLink">Beer Image Link</label>
        <input type="text" class="form-control" v-model="beer.beerImage" required />
      </div>
      <div class="data-inputs">
        <label for="description">Beer Description</label>
        <textarea name="description" class="text-area" cols="30" rows="8" v-model.lazy="beer.beerDescription"></textarea>
      </div>
      <div class="data-inputs">
        <label for="active">Beer Status</label>
        <div class="active-status">
          <input class="checkbox" type="checkbox" v-model="beer.active">
          <span v-show="beer.active">Active</span>
          <span v-show="!beer.active">Inactive</span>
        </div>
      </div>
      <div class="btn-container">
        <button class="btn blue">Submit</button>
        <button class="btn red" type="button" v-on:click="goBack">Cancel</button>
      </div>
      <p v-show="addBeerError">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js';

export default {
  name: 'new-beer-form',
  data() {
    return {
      beer: {
        beerId: 0,
        breweryId: this.$store.state.breweryId,
        beerName: '',
        beerType: '',
        beerAbv: 0.0,
        beerImage: '',
        beerDescription: '',
        active: false
      },
      addBeerError: false,
      errorMessage: ''
    }
  },
  methods: {
    addBeer() {
      beerService.create(this.beer)
      .then(response => {
        if (response.status === 200) {
          this.addBeerError = false;
          this.resetBeer();
          this.$router.push({ name: 'manageBeers' });
        }
      })
      .catch(error => {
        this.addBeerError = true;
        if (error.response) {
          this.errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
        } else if (error.request) {
          this.errorMessage = 'Error submitting form. Server could not be reached.';
        } else {
          this.errorMessage = 'Error submitting form. Request could not be created.';
        }
      });
    },
    resetBeer() {
      this.beer = {
        beerId: 0,
        beerName: '',
        beerType: '',
        beerAbv: 0.0,
        beerImage: '',
        beerDescription: '',
        active: false
      };
    },
    goBack() {
      this.$router.push({ name: 'manageBeers' });
    }
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
.text-area {
  font-size: 16px;
  border: 1px solid hsl(208, 49%, 24%);
  padding: 8px;
}
.checkbox {
  margin-right: 8px;
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