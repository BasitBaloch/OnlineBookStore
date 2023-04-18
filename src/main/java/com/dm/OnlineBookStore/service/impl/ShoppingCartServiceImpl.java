package com.dm.OnlineBookStore.service.impl;

import com.dm.OnlineBookStore.entity.CartItem;
import com.dm.OnlineBookStore.entity.Promotion;
import com.dm.OnlineBookStore.entity.ShoppingCart;
import com.dm.OnlineBookStore.repository.PromotionRepository;
import com.dm.OnlineBookStore.repository.ShoppingCartRepository;
import com.dm.OnlineBookStore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    PromotionRepository promotionRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    public double checkOut(Long cartId, String promotionCode){

        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId).orElseThrow();
        List<Promotion> promotions= promotionRepository.findByPromotionCode(promotionCode);
        shoppingCart.getCartItems().forEach(cartItem -> {
            promotions.stream().filter(promotion -> promotion.getBookType().equals(cartItem.getBook().getType()))
                    .forEach(promotion -> {
                        double discount=cartItem.getBook().getPrice()/ (promotion.getDiscount()/100);
                        cartItem.getBook().setPrice(cartItem.getBook().getPrice() - discount);
                    });
        });
        double totalPrice = shoppingCart.getCartItems().stream().mapToDouble(CartItem::getPrice).sum();

        return totalPrice;
    }
}
