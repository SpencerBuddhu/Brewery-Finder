<template>
  <div class="container">
    <h1>Manage Brewery</h1>
    <form class="form-card" v-on:submit.prevent="updateBrewery">
      <h2>Brewery Information</h2>
      <div class="contact-info">
        <div class="brewery-info">
          <div class="data-inputs">
            <label for="name">Brewery Name</label>
            <input type="text" class="form-control" v-model="breweryName" />
          </div>
          <div class="data-inputs">
            <label for="website">Brewery Website URL</label>
            <input type="text" class="form-control" v-model="websiteUrl" />
          </div>
          <div class="data-inputs">
            <label for="email">Brewery Email Address</label>
            <input type="email" class="form-control" v-model="emailAddress" />
          </div>
          <div class="data-inputs">
            <label for="telephone">Brewery Phone Number</label>
            <input type="tel" class="form-control" v-model="phoneNumber" />
          </div>
        </div>
        <div class="address-info">
          <div class="data-inputs">
            <label for="streetAddress">Street Address</label>
            <input type="text" class="form-control" v-model="streetAddress" />
          </div>
          <div class="data-inputs">
            <label for="city">City</label>
            <input type="text" class="form-control" v-model="city" />
          </div>
          <div class="data-inputs">
            <label for="state">State</label>
            <input type="text" class="form-control" v-model="state" />
          </div>
          <div class="data-inputs">
            <label for="zipcode">Zip Code</label>
            <input type="text" class="form-control" v-model="zipcode" />
          </div>
        </div>
      </div>
      <div class="data-inputs">
        <label for="logo">Brewery Logo Link</label>
        <input type="text" class="form-control" v-model="breweryLogo" />
      </div>
      <div class="data-inputs">
        <label for="image">Brewery Image Link</label>
        <input type="text" class="form-control" v-model="breweryImage" />
      </div>
      <div class="data-inputs">
        <label for="history">Brewery History</label>
        <textarea name="history" cols="30" rows="8" class="text-area" v-model.lazy="breweryHistory"></textarea>
      </div> 
      
      <h2>Business Hours</h2>
      <div class="days-hours" v-for="hour in hours" v-bind:key="hour.hoursId">
        <label class="day">{{ hour.day }}</label>
        <div class="business-hours">
          <input type="time" v-model="hour.openingHour">
          <span>to</span>
          <input type="time" v-model="hour.closingHour">
        </div>
      </div>
      <div class="data-inputs">
        <h2>Brewery Status</h2>
        <div class="active-status">
          <input class="checkbox" type="checkbox" v-model="active">
          <span v-show="active">Active&nbsp;&nbsp;(Brewery will display in Brewery List)</span>
          <span v-show="!active">Inactive&nbsp;&nbsp;(Brewery will not display in Brewery List)</span>
        </div>
      </div>
      <div class="btn-container">
        <button class="btn blue">Update</button>
        <button class="btn red" v-on:click="goHome">Cancel</button>
      </div>
      <p class="success" v-show="updateSuccess">{{ successMessage}}</p>
      <p class="failure" v-show="updateFailure">{{ errorMessage }}</p>
    </form>
  </div>
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
    },
    goHome() {
      this.$router.push({ name: 'home' });
    }
  },
  created() {
    this.getBrewerBrewery();
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
  width: 1024px;
  margin: 24px auto 0 auto;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  padding: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
  margin-bottom: 24px;
}
.contact-info {
  display: flex;
  justify-content: space-between;
}
.brewery-info, .address-info {
  width: 384px;
}
.data-inputs {
  display: flex;
  flex-direction: column;
  margin-bottom: 16px;
}
.data-inputs > label {
  font-size: 18px;
  color: hsl(208, 49%, 24%);
  padding: 8px;
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
.days-hours {
  display: flex;
  margin-bottom: 8px;
}
.day {
  width: 104px;
  font-size: 16px;
  color: hsl(208, 49%, 24%);
  padding-left: 8px;
}
.business-hours {
  width: 256px;
  display: flex;
  justify-content: space-around;
}
.checkbox {
  margin-right: 8px;
}
.active-status {
  padding-left: 8px;
}
.btn-container {
  width: 256px;
  display: flex;
  justify-content: space-evenly;
}
.btn {
  height: 48px;
  width: 80px;
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
.success {
  padding: 8px;
  color: #198754;
}
.failure {
  padding: 8px;
  color: #dc3545;
}
</style>