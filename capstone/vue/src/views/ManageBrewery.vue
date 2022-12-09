<template>
  <div>
    <navigation></navigation>
    <h1>Manage Brewery</h1>
    <update-brewery-form></update-brewery-form>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import UpdateBreweryForm from '../components/UpdateBreweryForm.vue';

export default {
  name: 'manage-brewery',
  components: {
    Navigation,
    UpdateBreweryForm,
  }
}
</script>

<style>

</style>