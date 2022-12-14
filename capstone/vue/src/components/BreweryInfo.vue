<template>
  <div class="brewery-info">
    <h1>{{breweryName}}</h1>
    <div class="container">
      <div class="brewery-contact-info">
        <div class="img-container">
          <img class="brewery-logo" v-bind:src="breweryLogo" v-bind:alt="breweryName + ' logo'">
        </div>
        <div class="contact-info">
          <h3>Contact Us</h3>
          <p>{{ streetAddress }}</p>
          <p>{{ address }}</p>
          <a class="links" v-bind:href="'tel:' + phoneNumber">{{ phoneNumber }}</a>
          <a class="links" v-bind:href="'mailto:' + emailAddress">{{ emailAddress }}</a>
          <a class="links" target="_blank" v-bind:href="websiteUrl">{{ websiteUrl }}</a>
        </div>
        <div class="business-hours">
          <h3>Business Hours</h3>
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
        </div>
      </div>
      <div class="brewery-description">
        <img class="brewery-image" v-bind:src="breweryImage" v-bind:alt="breweryName + ' image'">
        <div class="brewery-history">
          <h3>Brewery History</h3>
          <p class="brewery-desc">{{ breweryHistory }}</p>
        </div>
        
      </div>
    </div>
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
            return `${this.city}, ${this.state} ${this.zipcode}`;
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
<style scoped>
.brewery-info {
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
.container {
  display: flex;
  justify-content: space-between;
  margin: 16px 0;
}
.brewery-contact-info {
  width: 256px;
  color: hsl(208, 49%, 24%);
}
.brewery-description {
  width: 992px;
}
.img-container {
  width: 256px;
  height: 256px;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
.brewery-logo {
  width: 240px;
  height: 240px;
}
.contact-info {
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  padding: 16px;
  margin-bottom: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
.links {
  display: block;
  margin: 4px 0;
  text-decoration: none;
  color: hsl(208, 49%, 24%);
}
.links:visited {
  color: hsl(208, 49%, 24%);
}
.business-hours {
  width: 256px;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 16px 0;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
table {
  margin-top: 8px;
}
.brewery-image {
  /* height: 512px; */
  width: 992px;
  border-radius: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
.brewery-history {
  color: hsl(208, 49%, 24%);
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  padding: 16px;
  margin: 16px 0;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
</style>