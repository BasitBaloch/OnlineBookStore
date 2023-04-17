package com.dm.OnlineBookStore.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String author;
    private String type;
    private double price;
    private String isbn;

    @OneToMany(mappedBy="book", fetch = FetchType.LAZY)
    private List<CartItem> shoppingCart;

}
