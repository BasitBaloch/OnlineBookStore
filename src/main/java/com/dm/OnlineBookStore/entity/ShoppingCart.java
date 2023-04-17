package com.dm.OnlineBookStore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private double totalPrice;
    @OneToMany(mappedBy="shoppingCart")
    private List<CartItem> cartItems;
    @ManyToOne
    private User user;

}
