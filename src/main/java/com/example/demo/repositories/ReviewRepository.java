package com.example.demo.repositories;

import com.example.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByBookId(Long bookId);
    List<Review> findByUserId(Long userId);
    Optional<Review> findByBookIdAndUserId(Long bookId, Long userId);
}
