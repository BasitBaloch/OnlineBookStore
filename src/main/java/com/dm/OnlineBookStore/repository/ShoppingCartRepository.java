package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.ShoppingCart;
import com.dm.OnlineBookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUser(User user);

}