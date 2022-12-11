<template>
  <div class="manage-brewery">
    <navigation></navigation>
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

<style scoped>
.manage-brewery {
  /* height: 100vh; */
  background-color: hsl(13, 100%, 72%);
}
</style>