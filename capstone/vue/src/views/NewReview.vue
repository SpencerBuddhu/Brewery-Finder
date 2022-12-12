<template>
  <div class="new-review">
    <navigation></navigation>
    <new-review-form></new-review-form>
  </div>
</template>

<script>
import Navigation from '../components/Navigation.vue';
import NewReviewForm from '../components/NewReviewForm.vue';

export default {
  name: 'new-review',
  components: {
    Navigation,
    NewReviewForm
  }
}
</script>

<style scoped>
.new-review {
  height: 100vh;
  background-color: hsl(13, 100%, 72%);
}
</style>