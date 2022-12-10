<template>
  <div>
    <navigation></navigation>
    <h1>Add a Beer</h1>
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

</style>