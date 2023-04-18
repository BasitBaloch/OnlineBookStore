package com.dm.OnlineBookStore.service.impl;


import com.dm.OnlineBookStore.entity.Book;
import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.ShoppingCart;
import com.dm.OnlineBookStore.entity.User;
import com.dm.OnlineBookStore.repository.BookRepository;
import com.dm.OnlineBookStore.repository.CartItemRepository;
import com.dm.OnlineBookStore.repository.ShoppingCartRepository;
import com.dm.OnlineBookStore.service.BookStoreService;
import com.dm.OnlineBookStore.service.CartItemService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartItemService cartItemService;

    @Override
    public void addBook(Long id, int quantityToAdd, User user){
        ShoppingCart shoppingCart=null;
        shoppingCart = shoppingCartRepository.findByUser(user);
        if(ObjectUtils.isEmpty(shoppingCart)){
            shoppingCart= new ShoppingCart();
        }
        Book book = bookRepository.findById(id).orElseThrow();
        CartItem cartItem= new CartItem();
        cartItem.setBook(book);
        cartItem.setQuantity(quantityToAdd);
        cartItemRepository.save(cartItem);
        shoppingCart.getCartItems().add(cartItem);
        shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public void removeBook(Long id){
        CartItem cartItem= cartItemRepository.findById(id).orElseThrow();
        bookRepository.delete(cartItem.getBook());
        cartItemRepository.delete(cartItem);
    }

    @Override
    public List<CartItem> searchBookItem(String search){
        List<CartItem> cartItems = null;
        if(search != null){
            cartItems=cartItemRepository.findBySearch(search);
        }

        return cartItems;
    }

}