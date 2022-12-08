<template>
  <form v-on:submit.prevent>
    <div>
      <label for="name">Brewery Name</label>
      <input type="text" v-model="breweryToUpdate.breweryName" />
    </div>
    <div>
      <label for="website">Brewery Website URL</label>
      <input type="text" v-model="breweryToUpdate.websiteUrl" />
    </div>
    <div>
      <label for="email">Brewery Email Address</label>
      <input type="email" v-model="breweryToUpdate.emailAddress" />
    </div>
    <div>
      <label for="telephone">Brewery Phone Number</label>
      <input type="tel" v-model="breweryToUpdate.phoneNumber" />
    </div>
    <div>
      <label for="logo">Brewery Logo Link</label>
      <input type="text" v-model="breweryToUpdate.breweryLogo" />
    </div>
    <div>
      <label for="image">Brewery Image Link</label>
      <input type="text" v-model="breweryToUpdate.breweryImage" />
    </div>
    <div>
      <label for="history">Brewery History</label>
      <textarea name="history" cols="30" rows="10" v-model.lazy="breweryToUpdate.breweryHistory"></textarea>
    </div>
    <div>
      <label for="active">Brewery Status</label>
      <input type="checkbox" v-model="breweryToUpdate.active">
    </div>
  </form>
</template>

<script>
export default {
  name: 'update-brewery-form',
  props: ['brewery'],
  data() {
    return {
      breweryToUpdate: {
        breweryName: this.brewery.breweryName,
        websiteUrl: this.brewery.websiteUrl,
        emailAddress: this.brewery.emailAddress,
        phoneNumber: this.brewery.phoneNumber,
        breweryLogo: this.brewery.breweryLogo,
        breweryImage: this.brewery.breweryImage,
        breweryHistory: this.brewery.breweryHistory,
        active: this.brewery.active
      }
    }
  }
}
</script>

<style>

</style>