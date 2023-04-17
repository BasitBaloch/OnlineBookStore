package com.dm.OnlineBookStore.service.impl;

import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.repository.CartItemRepository;
import com.dm.OnlineBookStore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Override
    public List<CartItem> searchItem(String search) {
        return cartItemRepository.findBySearch(search);
    }
}
