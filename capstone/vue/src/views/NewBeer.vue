<template>
  <div class="new-beer-page">
    <navigation></navigation>
    <new-beer-form></new-beer-form>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import NewBeerForm from '../components/NewBeerForm.vue';

export default {
  name: 'new-beer',
  components: {
    Navigation,
    NewBeerForm
  }
}
</script>

<style>
.new-beer-page {
  background-color: hsl(13, 100%, 72%);
}
</style>