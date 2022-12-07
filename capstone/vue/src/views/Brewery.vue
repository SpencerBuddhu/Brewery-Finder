<template>
  <div>
    <brewery-info v-bind:brewery="brewery"></brewery-info>
  </div>
</template>

<script>
import BreweryInfo from '../components/BreweryInfo.vue';

export default {
  name: 'brewery',
  components: {
    BreweryInfo
  },
  computed: {
    brewery() {
      return this.$store.state.breweries.find((b) => {
        return b.breweryId === this.$route.params.id;
      });
    }
  }
}
</script>