package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.FavoriteBook;
import java.util.*;

public interface FavoriteRepository extends JpaRepository<FavoriteBook, Long>{
    List<FavoriteBook> findByUserId(Long userId);
}
