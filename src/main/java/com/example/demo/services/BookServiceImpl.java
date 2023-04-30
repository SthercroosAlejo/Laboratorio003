package com.example.demo.services;

// import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new
        EntityNotFoundException("Book not found with id " + id));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setDescription(bookDetails.getDescription());
        book.setImageUrl(bookDetails.getImageUrl());
        book.setUpdatedAt(LocalDateTime.now());
        return bookRepository.save(book);
    }

    // @Override
    // public List<Book> searchBooks(String keyword) {
    //     return bookRepository.searchBooks(keyword);
    // }

    @Override
    public Book addFavoriteBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(getBookById(id));
    }
}
