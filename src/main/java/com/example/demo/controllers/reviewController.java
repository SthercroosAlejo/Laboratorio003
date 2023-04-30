package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Review;
import com.example.demo.services.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class reviewController {
    private final ReviewService reviewService;

    public reviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review, @RequestParam Long bookId, @RequestParam Long userId){
        Review newReview = reviewService.createReview(review, bookId, userId);
        return ResponseEntity.ok(newReview);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId){
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable Long userId){
        List<Review> reviews = reviewService.getReviewsByUserId(userId);
        return ResponseEntity.ok(reviews);
    }
}
