package com.dm.OnlineBookStore.service;


import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.User;

import java.util.List;

public interface BookStoreService {
    void addBook(Long id, int quantityToAdd, User user);
    void removeBook(Long id);
    List<CartItem> searchBookItem(String search);


}