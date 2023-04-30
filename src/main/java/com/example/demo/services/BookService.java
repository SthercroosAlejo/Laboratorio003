package com.example.demo.services;

import com.example.demo.models.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book addFavoriteBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    // List<Book> searchBooks(String keyword);
}
