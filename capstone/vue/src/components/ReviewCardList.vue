<template>
  <div class="container">
    <h2>Reviews</h2>
    <div class="btn-container">
      <button class="btn blue" v-on:click="goToAddReview">Add Review</button>
    </div>
    <div class="review-card-list">
      <review-card v-for="review in this.reviews" v-bind:key="review.reviewId" v-bind:review="review"></review-card>
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
  data() {
    return {
      reviews: []
    }
  },
  methods: {
    getBeerReviews() {
      reviewService.list(this.$route.params.id)
      .then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_CURRENT_BEER_REVIEWS', response.data);
          this.reviews = response.data;
        }
      });
    },
    goToAddReview() {
      this.$router.push({name: 'addReview'});
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
  padding: 32px 0;
}
h2 {
  font-size: 48px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
}
.btn-container {
  width: 1024px;
  margin: 24px auto;
  display: flex;
  justify-content: flex-end;
}
.btn {
  width: 96px;
  height: 48px;
  font-size: 16px;
  color: hsl(0, 0%, 100%);
  border: none;
  border-radius: 8px;
  cursor: pointer;
}
.blue {
  background-color: #0d6efd;
}
.review-card-list {
  display: grid;
  grid-template-columns: 1fr 1fr;
  justify-items: center;
  gap: 32px;
}
</style>