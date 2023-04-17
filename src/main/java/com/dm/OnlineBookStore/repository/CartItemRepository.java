package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    @Query(value = "SELECT * FROM cart_item ci JOIN book b ON ci.book_id = b.id WHERE b.title LIKE %:search% OR b.author LIKE %:search% OR b.isbn LIKE %:search%", nativeQuery = true)
    List<CartItem> findBySearch(String search);
}