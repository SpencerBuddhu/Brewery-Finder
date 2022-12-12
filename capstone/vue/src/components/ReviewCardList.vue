<template>
  <div class="container">
    <h2>Reviews</h2>
    <div class="review-card-list">
      <review-card v-for="review in this.$store.state.currentBeerReviews" v-bind:key="review.reviewId" v-bind:review="review"></review-card>
    </div>
  </div>
</template>

<script>
import reviewService from '../services/ReviewService.js';
import ReviewCard from '../components/ReviewCard.vue';

export default {
  name: 'review-card-list',
  components: {
    ReviewCard
  },
  methods: {
    getBeerReviews() {
      reviewService.list(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_CURRENT_BEER_REVIEWS', response.data);
        }
      });
    }
  },
  created() {
    this.getBeerReviews();
  }
}
</script>

<style scoped>
.container {
  width: 1280px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  font-family: Ubuntu, sans-serif;
}
h2 {
  font-size: 48px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
}
.review-card-list {
  display: flex;
  flex-direction: column;
}
</style>