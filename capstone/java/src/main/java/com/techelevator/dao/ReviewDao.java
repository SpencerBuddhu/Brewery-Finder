package com.techelevator.dao;

import com.techelevator.model.Review;
import java.util.List;

public interface ReviewDao {

    List<Review> listReviews(int beerId);

    Review getReviewById(int reviewId);

    void addReview(Review aReview);

    void updateReview(Review review, int reviewId);

}
