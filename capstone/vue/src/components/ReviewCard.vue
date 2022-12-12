<template>
  <div class="review-card">
    <img v-if="this.review.img" v-bind:src="this.review.img" alt="User provided photo">
    <div class="review-info">
      <div class="rating">
        <img src="../assets/mug.png" v-bind:alt="this.review.rating + ' Beer Review'" v-for="n in this.review.rating" v-bind:key="n">
      </div>
      <p>{{ this.review.reviewText }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'review-card',
  props: ['review']
}
</script>

<style scoped>

</style>