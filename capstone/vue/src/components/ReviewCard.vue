<template>
  <div class="review-card">
    <!-- <img v-bind:src="review.img" alt="User provided photo"> -->

      <div class="rating">
        <p class="rating-heading">Beer Rating:</p>
        <img class="review-icon" src="../assets/mug.png" v-bind:alt="review.rating + ' Beer Review'" v-for="n in review.rating" v-bind:key="n">
      </div>
      <p>"{{ review.reviewText }}"</p>

  </div>
</template>

<script>
export default {
  name: 'review-card',
  props: ['review']
}
</script>

<style scoped>
.review-card {
  width: 512px;
  height: 192px;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
  padding: 32px;
}
.review-icon {
  width: 48px;
}
.rating {
  display: flex;
  align-items: center;
  margin-bottom: 24px;
}
.rating-heading {
  color: hsl(208, 49%, 24%);
  font-size: 24px;
}
</style>