<template>
  <form v-on:submit.prevent="updateBrewery">
    <div>
      <label for="name">Brewery Name</label>
      <input type="text" v-model="breweryName" />
    </div>
    <div>
      <label for="website">Brewery Website URL</label>
      <input type="text" v-model="websiteUrl" />
    </div>
    <div>
      <label for="email">Brewery Email Address</label>
      <input type="email" v-model="emailAddress" />
    </div>
    <div>
      <label for="telephone">Brewery Phone Number</label>
      <input type="tel" v-model="phoneNumber" />
    </div>
    <div>
      <label for="logo">Brewery Logo Link</label>
      <input type="text" v-model="breweryLogo" />
    </div>
    <div>
      <label for="image">Brewery Image Link</label>
      <input type="text" v-model="breweryImage" />
    </div>
    <div>
      <label for="history">Brewery History</label>
      <textarea name="history" cols="30" rows="10" v-model.lazy="breweryHistory"></textarea>
    </div>
    <div>
      <label for="active">Brewery Status</label>
      <input type="checkbox" v-model="active">
    </div>
    <div>
      <label for="streetAddress">Street Address</label>
      <input type="text" v-model="streetAddress" />
    </div>
    <div>
      <label for="city">City</label>
      <input type="text" v-model="city" />
    </div>
    <div>
      <label for="state">State</label>
      <input type="text" v-model="state" />
    </div>
    <div>
      <label for="zipcode">Zip Code</label>
      <input type="text" v-model="zipcode" />
    </div>
    <div v-for="hour in hours" v-bind:key="hour.hoursId">
      <label>{{ hour.day }}</label>
      <input type="time" v-model="hour.openingHour">
      <input type="time" v-model="hour.closingHour">
    </div>
    <button>Update Brewery Info</button>
    <p v-show="updateSuccess">{{ successMessage}}</p>
    <p v-show="updateFailure">{{ errorMessage }}</p>
  </form>
</template>

<script>
import breweryService from '../services/BreweryService.js';

export default {
  name: 'update-brewery-form',
  data() {
    return {
      breweryId: 0,
      breweryName: '',
      websiteUrl: '',
      emailAddress: '',
      phoneNumber: '',
      breweryLogo: '',
      breweryImage: '',
      breweryHistory: '',
      active: false,
      addressId: 0,
      streetAddress: '',
      city: '',
      state: '',
      zipcode: '',
      hours: [],
      updateSuccess: false,
      updateFailure: false,
      errorMessage: '',
      successMessage: 'Update successful!'
    }
  },
  methods: {
    getBrewerBrewery() {
      breweryService.get(this.$store.state.breweryId)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_BREWER_BREWERY', response.data);
          this.breweryName = response.data.breweryName;
          this.websiteUrl = response.data.websiteUrl;
          this.emailAddress = response.data.emailAddress;
          this.phoneNumber = response.data.phoneNumber;
          this.breweryLogo = response.data.breweryLogo;
          this.breweryImage = response.data.breweryImage;
          this.breweryHistory = response.data.breweryHistory;
          this.active = response.data.active;
          this.addressId = response.data.address.addressId;
          this.streetAddress = response.data.address.streetAddress;
          this.city = response.data.address.city;
          this.state = response.data.address.state;
          this.zipcode = response.data.address.zipcode;
          this.hours = response.data.hours
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
        });
    },
    updateBrewery() {
      const brewery = {
        breweryId: this.$store.state.breweryId,
        breweryName: this.breweryName,
        userId: this.$store.state.user.id,
        websiteUrl: this.websiteUrl,
        emailAddress: this.emailAddress,
        address: {
          addressId: this.addressId,
          streetAddress: this.streetAddress,
          city: this.city,
          state: this.state,
          zipcode: this.zipcode
        },
        hours: this.hours,
        phoneNumber: this.phoneNumber,
        breweryHistory: this.breweryHistory,
        breweryLogo: this.breweryLogo,
        breweryImage: this.breweryImage,
        active: this.active
      };
      breweryService.update(brewery.breweryId, brewery)
      .then(response => {
        if (response.status === 200) {
          this.updateSuccess = true;
        }
      })
      .catch(error => {
        if (error.response) {
          this.errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
        } else if (error.request) {
          this.errorMessage = 'Error submitting form. Server could not be reached.';
        } else {
          this.errorMessage = 'Error submitting form. Request could not be created.';
        }
      });
    }
  },
  created() {
    this.getBrewerBrewery();
  }
}
</script>

<style>

</style>