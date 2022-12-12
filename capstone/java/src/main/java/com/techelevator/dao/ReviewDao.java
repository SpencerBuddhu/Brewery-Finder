package com.techelevator.dao;

import com.techelevator.model.Review;
import java.util.List;

public interface ReviewDao {

    List<Review> listReviews(int beerId);

    void addReview(Review aReview);

    /*Review getReviewById(int reviewId);*/

    /*void updateReview(Review review, int reviewId);*/

}
