<template>
  <div>
    <img v-bind:src="this.beer.beerImage" v-bind:alt="this.beer.beerName" v-on:click="goToBeer">
  </div>
</template>

<script>
export default {
  name: 'beer-card',
  props: ['beer'],
  methods: {
    goToBeer() {
      this.$router.push({name: 'beers', params: {id: this.beer.beerId}});
    }
  }
}
</script>

<style scoped>
img {
  width: 256px;
  height: 256px;
}
img:hover {
  cursor: pointer;
}
</style>