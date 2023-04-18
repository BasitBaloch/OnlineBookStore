package com.dm.OnlineBookStore.controller;

import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.User;
import com.dm.OnlineBookStore.service.BookStoreService;
import com.dm.OnlineBookStore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService, ShoppingCartService shoppingCartService) {
        this.bookStoreService = bookStoreService;
        this.shoppingCartService = shoppingCartService;
    }

    @PutMapping("/add-book/{id}/{quantityToAdd}")
    @ResponseStatus(HttpStatus.OK)
    public void addBookToStore(@RequestParam Long id,
                        @RequestParam int quantityToAdd) {
        User user= new User();
        bookStoreService.addBook(id, quantityToAdd, user);
    }


    @DeleteMapping("/remove-book/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeBookItem(@PathVariable Long cartItemId) {
        User user= new User();
        bookStoreService.removeBook(cartItemId);
    }

    @GetMapping("/search-book")
    @ResponseStatus(HttpStatus.OK)
    public List<CartItem> searchBook(@RequestParam String search) {
        return bookStoreService.searchBookItem(search);
    }

    @PutMapping("/checkOut")
    @ResponseStatus(HttpStatus.OK)
    public void addBookToStore(@RequestParam String promotionCode,
                               @RequestParam Long cartId) {
        User user= new User();
        shoppingCartService.checkOut(cartId, promotionCode);
    }


}