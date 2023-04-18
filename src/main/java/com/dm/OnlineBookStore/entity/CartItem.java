package com.dm.OnlineBookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private int quantity;
    private double price;
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private ShoppingCart shoppingCart;

}
