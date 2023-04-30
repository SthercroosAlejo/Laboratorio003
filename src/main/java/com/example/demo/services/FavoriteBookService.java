package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.models.Book;
import com.example.demo.models.FavoriteBook;

@Service
public interface FavoriteBookService {
    FavoriteBook addFavoriteBook(Long bookId, Long userId);
    List<Book> getFavoriteBooksByUserId(Long userId);
    void deleteFavoriteBook(Long bookId, Long userId);
}
