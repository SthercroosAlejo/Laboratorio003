package com.example.demo.services;

import com.example.demo.models.Review;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ReviewService {
    Review createReview(Review reviReview, Long bookId, Long userId);
    List<Review> getAllReviews();
    Review getReviewByBookIdAndUserId(Long bookId, Long userId);
    List<Review> getReviewsByBookId(Long bookId);
    List<Review> getReviewsByUserId(Long userId);
    Review updateReview(Long id, Review review);
    Review getReviewById(Long id);
    void deleteReview(Long id);
}
