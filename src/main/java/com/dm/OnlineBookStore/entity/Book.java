package com.dm.OnlineBookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
