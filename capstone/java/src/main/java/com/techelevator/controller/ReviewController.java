package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Review;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    // List Reviews
    @RequestMapping(path = "/reviews/{beerId}", method = RequestMethod.GET)
    public List<Review> listReviews(@PathVariable int beerId) {
            return  reviewDao.listReviews(beerId);
    }

    // Get Review By Id
    @RequestMapping(path = "/reviews/{reviewId}", method = RequestMethod.GET)
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewDao.getReviewById(reviewId);
    }

    // Add Review
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void addReview(@RequestBody Review review) {
        reviewDao.addReview(review);
    }

    // Update Review
    @RequestMapping(path = "/reviews/{reviewId}", method = RequestMethod.PUT)
    public void updateReview(@RequestBody Review review, @PathVariable int reviewId) {
        reviewDao.updateReview(review, reviewId);
    }
}
