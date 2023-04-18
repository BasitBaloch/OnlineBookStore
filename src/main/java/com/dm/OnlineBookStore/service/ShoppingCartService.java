package com.dm.OnlineBookStore.service;

import com.dm.OnlineBookStore.entity.Promotion;
import com.dm.OnlineBookStore.entity.ShoppingCart;

public interface ShoppingCartService {

    public double checkOut(Long cartId, String promotionCode);
}
