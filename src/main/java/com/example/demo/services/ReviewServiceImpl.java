package com.example.demo.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Book;
import com.example.demo.models.Review;
import com.example.demo.models.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepository;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             BookRepository bookRepository,
                             UserRepository userRepository){
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
     public Review createReview(Review review, Long bookId, Long userId){
        Book book = bookRepository.findById(bookId).orElseThrow(()->new
                EntityNotFoundException("Book not found with id "+bookId));
         User user = userRepository.findById(userId).orElseThrow(()->new
                 EntityNotFoundException("User not found with id "+userId));
         review.setBook(book);
         review.setUser(user);
         return reviewRepository.save(review);
     }

    @Override
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewByBookIdAndUserId(Long bookId, Long userId) {
        return reviewRepository.findByBookIdAndUserId(bookId, userId).orElseThrow(()->new
                EntityNotFoundException("Review not found with bookId "+bookId+" and userId "+userId));
    }

    @Override
     public List<Review> getReviewsByBookId(Long bookId){
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public List<Review> getReviewsByUserId(Long userId){
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public Review updateReview(Long id, Review reviewDetails){
        Review review = getReviewById(id);
        review.setTitle(reviewDetails.getTitle());
        review.setComment(reviewDetails.getComment());
        review.setRating(reviewDetails.getRating());
        review.setUpdatedAt(LocalDateTime.now());
        return review;
    }

    @Override
    public Review getReviewById(Long id){
        return reviewRepository.findById(id).orElseThrow(()->new
                EntityNotFoundException("Review not found with id "+id));
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(getReviewById(id));
    }
}