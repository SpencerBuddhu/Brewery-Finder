package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> listReviews(int beerId) {
        List<Review> reviews = new ArrayList<>();
        String sql =    "SELECT * FROM reviews a " +
                        "JOIN beer_reviews b ON a.review_id = b.review_id " +
                        "WHERE beer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Review getReviewById(int reviewId) {
        Review review = null;
        String sql = "SELECT * FROM reviews WHERE review_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (results.next()) {
            review = mapRowToReview(results);
        }
        return review;
    }

    /* ????? */
    @Override
    public void addReview(Review aReview) {
        String sqlAddReview = "INSERT INTO reviews (review_text, user_id, image) VALUES(?,?,?) RETURNING review_id";
        int newReviewId = jdbcTemplate.queryForObject(sqlAddReview, int.class, aReview.getReviewText(), aReview.getUserId(), aReview.getImage());
        String sqlBeerReviews = "INSERT INTO beer_reviews (beer_id, review_id) VALUES(?, ?)";
        jdbcTemplate.update(sqlBeerReviews, aReview.getReviewId(), newReviewId);

    }

    @Override
    public void updateReview(Review review, int reviewId) {
        String sql = "UPDATE reviews SET review_text = ?, user_id = ?, image = ?";
        jdbcTemplate.update(sql, review.getReviewText(), review.getUserId(), review.getImage());
    }

    private Review mapRowToReview(SqlRowSet results) {
        Review review = new Review();
        review.setReviewId(results.getInt("review_id"));
        review.setReviewText(results.getString("review_text"));
        review.setUserId(results.getInt("user_id"));
        review.setImage(results.getString("image"));
        return review;
    }
}
