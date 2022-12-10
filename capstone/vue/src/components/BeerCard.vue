<template>
  <div>
    <img v-bind:src="this.beer.beerImage" v-bind:alt="this.beer.beerName">
  </div>
</template>

<script>
export default {
  name: 'beer-card',
  props: ['beer']
}
</script>

<style>

</style>