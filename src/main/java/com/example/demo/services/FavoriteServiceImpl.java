package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Book;
import com.example.demo.models.FavoriteBook;
import com.example.demo.repositories.FavoriteRepository;
import java.util.*;

@Service
public class FavoriteServiceImpl implements FavoriteBookService{

    @Autowired
    private FavoriteRepository favoriteRepository;
    private BookService bookService;
    private UserService userService;

    @Override
    public FavoriteBook addFavoriteBook(Long bookId, Long userId) {
        FavoriteBook favoriteBook = new FavoriteBook();
        favoriteBook.setBook(bookService.getBookById(bookId));        
        favoriteBook.setUser(userService.getUserById(userId));
        return favoriteRepository.save(favoriteBook);
    }

    @Override
    public List<Book> getFavoriteBooksByUserId(Long userId) {
        List<FavoriteBook> favoriteBooks = favoriteRepository.findByUserId(userId);
        List<Book> books = new ArrayList<>();
        for(FavoriteBook favoriteBook : favoriteBooks){
            books.add(favoriteBook.getBook());
        }
        return books;
    }

    @Override
    public void deleteFavoriteBook(Long booId, Long userId) {
        List<FavoriteBook> favoriteBooks = favoriteRepository.findByUserId(userId);
        for(FavoriteBook favoriteBook : favoriteBooks){
            if(favoriteBook.getBook().getId() == booId){
                favoriteRepository.delete(favoriteBook);
            }
        }
    }
}