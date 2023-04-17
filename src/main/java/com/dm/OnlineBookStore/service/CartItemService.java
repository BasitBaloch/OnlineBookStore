package com.dm.OnlineBookStore.service;

import com.dm.OnlineBookStore.entity.CartItem;

import java.util.List;

public interface CartItemService {
    public List<CartItem> searchItem(String search);

}
