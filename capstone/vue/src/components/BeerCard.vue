<template>
  <div class="beer-card">
    <img v-bind:src="this.beer.beerImage" v-bind:alt="this.beer.beerName" v-on:click="goToBeer">
    <div class="beer-info">
      <p>{{ this.beer.beerName }}</p>
      <p>{{ this.beer.beerType }}</p>
    </div>
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
.beer-card {
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
}
img {
  width: 256px;
  height: 256px;
  border-top-left-radius: 16px;
  border-top-right-radius: 16px;
}
img:hover {
  cursor: pointer;
}
.beer-info {
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  padding: 16px 0;
  border-bottom-left-radius: 16px;
  border-bottom-right-radius: 16px;
}
</style>