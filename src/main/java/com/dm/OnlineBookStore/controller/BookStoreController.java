package com.dm.OnlineBookStore.controller;

import com.dm.OnlineBookStore.entity.User;
import com.dm.OnlineBookStore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
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

}