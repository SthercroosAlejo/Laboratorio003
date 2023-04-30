package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findAll();
    Optional<Book> findById(Long id);
    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String keyword);
}

