<template>
  <div>
    <h1>{{breweryName}}</h1>
    <img v-bind:src="breweryLogo" v-bind:alt="breweryName + ' logo'">
    <img v-bind:src="breweryImage" v-bind:alt="breweryName + ' image'">
    <p>{{ address }}</p>
    <p>{{ phoneNumber }}</p>
    <p>{{ emailAddress }}</p>
    <p>{{ websiteUrl }}</p>
    <!-- <div v-for="hour in hours" v-bind:key="hour.hoursId">
      <label>{{ hour.day }}</label>
      <input type="time" v-model="hour.openingHour">
      <input type="time" v-model="hour.closingHour">
    </div> -->
    <table>
      <thead>
        <tr>
          <th>Day</th>
          <th>Open</th>
          <th>Close</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="hour in businessHours" v-bind:key="hour.hoursId">
          <td>{{ hour.day }}</td>
          <td>{{ hour.openingHour }}</td>
          <td>{{ hour.closingHour }}</td>
        </tr>
      </tbody>
    </table>
    <p>{{ breweryHistory }}</p>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService.js';

export default {
    name: 'brewery-info',
    data() {
      return {
        breweryName: '',
        websiteUrl: '',
        emailAddress: '',
        phoneNumber: '',
        breweryLogo: '',
        breweryImage: '',
        breweryHistory: '',
        active: false,
        streetAddress: '',
        city: '',
        state: '',
        zipcode: '',
        hours: [],
      }
  },
    computed: {
        address() {
            return `${this.streetAddress}, ${this.city}, ${this.state} ${this.zipcode}`;
        },
        businessHours() {
          return this.hours.map(hour => {
            return {
              hoursId: hour.hoursId,
              day: hour.day,
              openingHour: this.displayTime(hour.openingHour),
              closingHour: this.displayTime(hour.closingHour)
            };
          })
        }
    },
    methods: {
    getCurrentBrewery() {
      breweryService.get(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_CURRENT_BREWERY', response.data);
          this.breweryName = response.data.breweryName;
          this.websiteUrl = response.data.websiteUrl;
          this.emailAddress = response.data.emailAddress;
          this.phoneNumber = response.data.phoneNumber;
          this.breweryLogo = response.data.breweryLogo;
          this.breweryImage = response.data.breweryImage;
          this.breweryHistory = response.data.breweryHistory;
          this.active = response.data.active;
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
    displayTime(timeString) {
      const now = new Date();
      let tempDate = new Date(now.toDateString() + ' ' + timeString);
      return tempDate.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true });
    }
  },
  created() {
    this.getCurrentBrewery();
  }
}
</script>