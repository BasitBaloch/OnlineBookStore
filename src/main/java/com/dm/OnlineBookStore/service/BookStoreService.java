package com.dm.OnlineBookStore.service;


import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.User;
import com.dm.OnlineBookStore.model.BookModel;

import java.util.List;

public interface BookStoreService {
    //void addNewBook(BookModel BookModel);

    void addBook(Long id, int quantityToAdd, User user);
    void removeBook(Long id);

    List<CartItem> searchBookItem(String search);

//    BookModel getBookById(Long id);
//
//    List<BookModel> getAllBooks();
//
//    int getNumberOfBooksById(Long id);
//
//    void updateBook(Long id, BookModel BookModel);
//
//    void sellBook(Long id);
//
//    void sellBooks(List<SellDto> sellDtos);
//
//    List<BookModel> getBookByCategoryKeyWord(String keyword, Category category);
//
//    int getNumberOfBooksSoldByCategoryAndKeyword(String keyword, Category category);

}