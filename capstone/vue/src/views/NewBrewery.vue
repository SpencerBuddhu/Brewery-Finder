<template>
  <div>
    <h2>Add a Brewery</h2>
    <new-brewery-form></new-brewery-form>
  </div>
</template>
<script>
import NewBreweryForm from '../components/NewBreweryForm.vue';

export default {
  name: 'new-brewery',
  components: {
    NewBreweryForm
  }
}
</script>
