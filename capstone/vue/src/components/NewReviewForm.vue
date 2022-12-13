<template>
  <div class="container">
    <h1>Add Review</h1>
    
    <form class="form-card" v-on:submit.prevent="addReview">
      <h2>Review Details</h2>
      <div class="data-inputs">
        <label for="review">Review Text</label>
        <textarea name="review" class="text-area" cols="30" rows="8" v-model.lazy="review.reviewText" required></textarea>
      </div>
      <div class="data-inputs">
        <label for="rating">Rating</label>
        <select name="rating" class="form-control" v-model.number="review.rating" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
      <!-- <div class="data-inputs">
        <label for="imageLink">Image Link</label>
        <input type="text" class="form-control" v-model="review.image" />
      </div> -->
      <div class="btn-container">
        <button class="btn blue">Submit</button>
        <button class="btn red" type="button" v-on:click="goBack">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
import reviewService from '../services/ReviewService.js';

export default {
  name: 'new-review-form',
  data() {
    return {
      review: {
        reviewId: 0,
        userId: this.$store.state.user.id,
        beerId: this.$store.state.currentBeer.beerId,
        reviewText: '',
        image: '',
        rating: 0
      },
      addReviewError: false,
      errorMessage: ''
    }
  },
  methods: {
    addReview() {
      reviewService.create(this.review)
      .then(response => {
        if (response.status === 200) {
          this.addReviewError = false;
          this.resetReview();
          this.$router.push({ name: 'beers', params: {id: this.$store.state.currentBeer.beerId} });
        }
      })
      .catch(error => {
        this.addReviewError = true;
        if (error.response) {
          this.errorMessage = `${error.response.status}: ${error.response.data.error}, ${error.response.data.message}`;
        } else if (error.request) {
          this.errorMessage = 'Error submitting form. Server could not be reached.';
        } else {
          this.errorMessage = 'Error submitting form. Request could not be created.';
        }
      });
    },
    resetReview() {
      this.review = {
        reviewId: 0,
        userId: this.$store.state.user.id,
        beerId: this.$store.state.currentBeer.beerId,
        reviewText: '',
        image: '',
        rating: 0
      }
    },
    goBack() {
      this.$router.push({ name: 'beers', params: { id: this.$store.state.currentBeer.beerId }});
    }
  }
}
</script>

<style scoped>
.container {
  font-family: Ubuntu, sans-serif;
  width: 1280px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
h1 {
  font-size: 80px;
  background-color: hsl(207, 13%, 34%);
  color: hsl(0, 0%, 100%);
  text-align: center;
  border-radius: 16px;
}
h2 {
  color: hsl(208, 49%, 24%);
  margin-bottom: 8px;
}
.form-card {
  width: 512px;
  margin: 24px auto 0 auto;
  display: flex;
  flex-direction: column;
  background-color: hsl(0, 0%, 100%);
  border-radius: 16px;
  padding: 16px;
  box-shadow: 4px 8px 8px rgb(90, 90, 90);
  margin-bottom: 24px;
}
.data-inputs {
  display: flex;
  flex-direction: column;
  margin-bottom: 16px;
}
.data-inputs > label {
  font-size: 18px;
  color: hsl(208, 49%, 24%);
  padding: 8px 0;
}
.form-control {
  height: 32px;
  font-size: 16px;
  border: 1px solid hsl(208, 49%, 24%);
  padding-left: 8px;
}
.text-area {
  font-size: 16px;
  border: 1px solid hsl(208, 49%, 24%);
  padding: 8px;
}
.btn-container {
  width: 256px;
  display: flex;
  justify-content: space-evenly;
}
.btn {
  width: 96px;
  height: 48px;
  font-size: 16px;
  color: hsl(0, 0%, 100%);
  padding: 0 8px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  margin-top: 16px;
}
.blue {
  background-color: #0d6efd;
}
.red {
  background-color: #dc3545;
}
</style>